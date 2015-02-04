package com.stone.actor;

import com.stone.actor.call.IActorCall;
import com.stone.actor.call.IActorCallback;
import com.stone.actor.future.IActorFuture;
import com.stone.actor.id.IActorId;
import com.stone.actor.system.IActorSystem;
import com.stone.core.msg.IMessage;

/**
 * Actor;
 * <p>
 * you know, no thread and lock and other fucking concurrent things, just actor
 * model;
 * 
 * @author crazyjohn
 *
 */
public interface IActor {
	/**
	 * sumit a simple call to actor;
	 * 
	 * @param call
	 * @return
	 */
	public <T> IActorFuture<T> submit(IActorCall<T> call);

	/**
	 * submit a net message;
	 * 
	 * @param message
	 */
	public void submit(IMessage message);

	/**
	 * submit a simple callback and result to actor;
	 * 
	 * @param callback
	 * @param result
	 */
	public void submit(IActorCallback<?> callback, Object result);

	/**
	 * the actor's main loop;
	 */
	public void react();

	/**
	 * get my actorId;
	 * 
	 * @return
	 */
	public IActorId getActorId();

	/**
	 * set actor id;
	 * 
	 * @param id
	 */
	public void setActorId(IActorId id);

	/**
	 * has any work to do?
	 * 
	 * @return
	 */
	public boolean hasAnyWorkToDo();

	/**
	 * get host actor system;
	 * 
	 * @return
	 */
	public IActorSystem getHostSystem();

	/**
	 * set host actor system;
	 * 
	 * @param actorSystem
	 */
	public void setHostSystem(IActorSystem actorSystem);

}
