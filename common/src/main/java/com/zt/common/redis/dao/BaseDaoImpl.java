package com.zt.common.redis.dao;

import com.zt.common.redis.RedisProxy;
import com.zt.common.redis.StringRedisTemplate;
import org.springframework.data.redis.core.RedisCommand;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author
 * @version 1.0, 2014-11-18
 */
@Repository
public class BaseDaoImpl implements BaseDao {

	@Resource(name="RedisProxy")

	private RedisProxy proxy;
	
	public BaseDaoImpl()
	{
	}
	
	public StringRedisTemplate getStringRedisTemplate(RedisCommand command) {
		return proxy.getStringRedisTemplate(command);
	}
	
	public RedisTemplate getRedisTemplate(RedisCommand command) {
		return proxy.getRedisTemplate(command);
	}
	public RedisTemplate getMasterRedisTemplate(){
		return proxy.getMasterRedisTemplate();
	}
	public StringRedisTemplate getMasterStringRedisTemplate(){
		return proxy.getMasterStringRedisTemplate();
	}
	/**
	 * 查找KEY
	 * @param key
	 * @return
	 */
	public String findKey(String key) {  
        return getStringRedisTemplate(RedisCommand.GET).opsForValue().get(key);  
    }  
      

	/**
	 * 键是否存在
	 * @param key
	 * @return
	 */
	public boolean hasKey(String key) {
		return getStringRedisTemplate(RedisCommand.EXISTS).hasKey(key);
	}
	
	/**
	 * 获取
	 * @param key
	 * @return
	 */
	protected long  getIncrement(String key){  
        RedisAtomicLong entityIdCounter=new RedisAtomicLong(key, getStringRedisTemplate(RedisCommand.INCR).getConnectionFactory());  
        return entityIdCounter.incrementAndGet();  
    }  
//	/**
//	 * 操作SET
//	 * @param key
//	 * @return
//	 */
//	protected RedisSet<String> redisSet(String key) {  
//        return new DefaultRedisSet<String>(key, getStringRedisTemplate());  
//    }
//	
//	/**
//	 * 操作MAP
//	 * @param key
//	 * @return
//	 */
//	protected RedisMap<String, String> redisMap(String key) {  
//        return new DefaultRedisMap<String, String>(key, getStringRedisTemplate());  
//    }
//	
//	/**
//	 * 操作LIST  
//	 * @param key
//	 * @return
//	 */
//	protected RedisList<String> redisList(String key) {  
//        return new DefaultRedisList<String>(key, getStringRedisTemplate());  
//    }
}
