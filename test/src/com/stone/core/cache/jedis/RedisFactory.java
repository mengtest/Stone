package com.stone.core.cache.jedis;

import redis.clients.jedis.JedisPool;

public class RedisFactory implements IRedisClientFactory {
	private JedisPool pool;

	public RedisFactory(String host, int port) {
		pool = new JedisPool(host, port);
	}

	@Override
	public RedisClient createRedisClient() {
		return new RedisClient(pool.getResource());
	}

	@Override
	public void close() {
		pool.close();
	}

}
