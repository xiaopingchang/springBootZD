package com.zt.common.redis.dao;

import com.zt.common.redis.StringRedisTemplate;
import org.springframework.data.redis.core.RedisCommand;

/**
 * @author Deyun Chen
 * @version 1.0, 2014-11-18
 */
public interface BaseDao {
	StringRedisTemplate getStringRedisTemplate(RedisCommand command);
}
