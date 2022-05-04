package com.connection;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisConnection {
	public final static RedisClient redisClient = RedisClient.create("redis://localhost:8885/0");
	public final static StatefulRedisConnection<String, String> connection = redisClient.connect();
	
	public static RedisCommands<String, String> redisConnection2() {
		 // change to reflect your environment
		
		RedisCommands<String, String> syncCommands = connection.sync();
		return syncCommands;
		
	}

}
