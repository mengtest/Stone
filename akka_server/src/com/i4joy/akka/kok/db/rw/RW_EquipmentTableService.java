package com.i4joy.akka.kok.db.rw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.Cancellable;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.contrib.pattern.DistributedPubSubExtension;
import akka.contrib.pattern.DistributedPubSubMediator;
import akka.routing.RandomRouter;

import com.google.common.base.Optional;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.i4joy.akka.kok.io.protocol.Heart;
import com.ump.impl.JdbcEquipmentDAO;
import com.ump.model.DBCache;
import com.ump.model.Equipment;
import com.ump.model.Player_equipments;

public class RW_EquipmentTableService extends UntypedActor {
	protected final Log logger = LogFactory.getLog(getClass());

	public static Props props(DataSource dataSource, String DBName) {
		return Props.create(RW_EquipmentTableService.class, dataSource, DBName);
	}

	private static LoadingCache<Integer, Optional<List<Equipment>>> hmCache;
	private static HashMap<Integer, String[]> listCache = new HashMap<Integer, String[]>();
	private ActorRef selectWorker;
	private ActorRef insertUpdateWorker;

	private String DBName;
	private int nrOfWorkers = 16;// 初始路由工人数量
	private ActorRef mediator = DistributedPubSubExtension.get(getContext().system()).mediator();// 集群代理
	private Cancellable heart;// 心跳 清理缓存中超时的

	public RW_EquipmentTableService(DataSource dataSource, String DBName) {
		this.DBName = DBName;
	}

	@Override
	public void preStart() throws Exception {
		hmCache = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.MINUTES).expireAfterAccess(10, TimeUnit.MINUTES).build(new CacheLoader<Integer, Optional<List<Equipment>>>() {
			@Override
			public Optional<List<Equipment>> load(Integer key) throws Exception {
				String[] strs = listCache.get(key);
				if (strs == null) {
					return Optional.fromNullable(null);
				} else {
					listCache.remove(key);
					return Optional.fromNullable(JdbcEquipmentDAO.getInstance().getEquipmentList(strs));
				}

			}
		});
		heart = getContext().system().scheduler().schedule(Duration.create(5, "seconds"), Duration.create(5, "seconds"), getSelf(), new Heart(), getContext().dispatcher(), getSelf());
		selectWorker = getContext().actorOf(Props.create(EquipmentSelectWorker.class).withRouter(new RandomRouter(nrOfWorkers)));
		insertUpdateWorker = getContext().actorOf(Props.create(EquipmentInsertUpDateWorker.class));
		mediator.tell(new DistributedPubSubMediator.Subscribe(DBName + Equipment.tableName, getSelf()), getSelf());
		super.preStart();
	}

	@Override
	public void postStop() throws Exception {
		heart.cancel();
		mediator.tell(new DistributedPubSubMediator.Unsubscribe(DBName + Equipment.tableName, getSelf()), getSelf());
		super.postStop();
	}

	@Override
	public void onReceive(Object msg) throws Exception {
		if (msg instanceof DBCache) {
			DBCache pg = (DBCache) msg;
			if (pg.getAction() == DBCache.SELECT) {
				selectWorker.tell(pg, getSender());
			} else if (pg.getAction() == DBCache.INSERT || pg.getAction() == DBCache.UPDATE) {
				insertUpdateWorker.tell(pg, getSender());
			} else if (msg instanceof Heart) {
				hmCache.cleanUp();
			}
		}
	}

	public static void addCache(Equipment pg) throws ExecutionException {

		Optional<List<Equipment>> op = hmCache.get((int) pg.getOwner_id());
		if (op.isPresent()) {
			op.get().add(pg);
		} else {
			List<Equipment> list = new ArrayList<Equipment>();
			list.add(pg);
			hmCache.put((int) pg.getOwner_id(), Optional.fromNullable(list));
		}
	}

	public static class EquipmentSelectWorker extends UntypedActor {

		@Override
		public void onReceive(Object msg) throws Exception {
			if (msg instanceof Player_equipments) {// 收到请求角色消息
				Player_equipments pm = (Player_equipments) msg;
				List<JSONObject> jsonList = pm.getPlayer_equipmentsList();
				String[] strs = new String[jsonList.size()];
				for (int i = 0; i < jsonList.size(); i++) {
					strs[i] = jsonList.get(i).getString("entityId");
				}
				listCache.put(pm.getPlayer_id(), strs);
				Optional<List<Equipment>> pg = hmCache.get(pm.getPlayer_id());
				List<Equipment> list = new ArrayList<Equipment>();
				if (pg.isPresent()) {
					list = pg.get();
				}
				getSender().tell(list, getSelf());
			}
		}
	}

	public static class EquipmentInsertUpDateWorker extends UntypedActor {
		private HashMap<Long, Equipment> hmInsert = new HashMap<Long, Equipment>();
		private HashMap<Long, Equipment> hmUpDate = new HashMap<Long, Equipment>();
		private Cancellable heart;// 心跳 清理缓存中超时的

		@Override
		public void preStart() throws Exception {
			getContext().system().scheduler().schedule(Duration.create(5, "seconds"), Duration.create(5, "seconds"), getSelf(), new Heart(), getContext().dispatcher(), getSelf());
			super.preStart();
		}

		@Override
		public void postStop() throws Exception {
			heart.cancel();
			super.postStop();
		}

		@Override
		public void onReceive(Object msg) throws Exception {
			if (msg instanceof Equipment) {// 收到请求角色消息
				Equipment pg = (Equipment) msg;
				if (pg.getAction() == DBCache.INSERT) {
					addCache(pg);
					hmInsert.put(pg.getEquipment_id(), pg);
				} else if (pg.getAction() == DBCache.UPDATE) {
					addCache(pg);
					hmUpDate.put(pg.getEquipment_id(), pg);
				}

			} else if (msg instanceof Heart) {
				int len = hmInsert.size();
				if (len > 0) {
					Equipment[] pgs = new Equipment[len];
					hmInsert.values().toArray(pgs);
					JdbcEquipmentDAO.getInstance().addList(pgs);
					hmInsert.clear();
				}

				len = hmUpDate.size();
				if (len > 0) {
					Equipment[] pgs = new Equipment[len];
					hmUpDate.values().toArray(pgs);
					JdbcEquipmentDAO.getInstance().upDateList(pgs);
					hmUpDate.clear();
				}
			}
		}
	}
}