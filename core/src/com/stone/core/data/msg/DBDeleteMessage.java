package com.stone.core.data.msg;

import com.stone.core.entity.IEntity;

public class DBDeleteMessage implements IDBMessage, IDBEntityMessage {

	private final IEntity entity;

	public DBDeleteMessage(IEntity entity) {
		this.entity = entity;
	}

	@Override
	public Class<?> getEntityClass() {
		return entity.getClass();
	}

	@Override
	public IEntity getEntity() {
		return entity;
	}

	@Override
	public long getId() {
		return entity.getId();
	}

}
