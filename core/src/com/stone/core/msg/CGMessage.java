package com.stone.core.msg;

import akka.actor.ActorRef;

import com.stone.core.session.GameActorSession;

/**
 * client和GameServer通信消息接口;
 * 
 * @author crazyjohn
 *
 */
public interface CGMessage extends ISessionMessage<GameActorSession> {

	/**
	 * Get the player actor;
	 * 
	 * @return
	 */
	public ActorRef getPlayerActor();

}
