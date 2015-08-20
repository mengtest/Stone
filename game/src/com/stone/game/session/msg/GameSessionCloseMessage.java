package com.stone.game.session.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stone.core.msg.BaseCGMessage;
import com.stone.core.msg.MessageParseException;
import com.stone.core.session.GameActorSession;

/**
 * Game session close message;
 * 
 * @author crazyjohn
 *
 */
public class GameSessionCloseMessage extends BaseCGMessage {
	private Logger logger = LoggerFactory.getLogger(GameSessionCloseMessage.class);

	public GameSessionCloseMessage(GameActorSession sessionInfo) {
		this.session = sessionInfo;
	}

	@Override
	public void execute() throws MessageParseException {
		logger.info(String.format("Session closed: %s", this.session));
	}

	@Override
	protected boolean readBody() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected boolean writeBody() {
		throw new UnsupportedOperationException();
	}

}
