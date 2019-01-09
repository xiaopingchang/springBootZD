package com.zt.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class WriteRedisTemplate extends RedisTemplate {
	
	public WriteRedisTemplate() {
		setKeySerializer(new org.springframework.data.redis.serializer.StringRedisSerializer());
		setValueSerializer(new org.springframework.data.redis.serializer.JdkSerializationRedisSerializer());
		setHashKeySerializer(new org.springframework.data.redis.serializer.StringRedisSerializer());
		setHashValueSerializer(new org.springframework.data.redis.serializer.JdkSerializationRedisSerializer());
	}
	
	@Override
	@Autowired(required = false)
	@Qualifier("jedisConnectionFactory")
	public void setConnectionFactory(RedisConnectionFactory connectionFactory) {
		super.setConnectionFactory(connectionFactory);
	}
}
