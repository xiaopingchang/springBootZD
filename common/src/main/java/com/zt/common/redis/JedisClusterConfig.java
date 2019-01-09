package com.zt.common.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisPoolingClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(JedisCluster.class)
@EnableConfigurationProperties(JedisConfigProperties.class)
public class JedisClusterConfig {
	
	@Value("${x.redis.master.host}")
	private String masterHost;
	
	@Value("${x.redis.master.port}")
	private int masterPoint;
	
//	@Value("${x.redis.slave.host}")
//	private String slaveHost;
	
//	@Value("${x.redis.slave.port}")
//	private int slavePoint;
	
	@Resource
    private JedisConfigProperties jedisConfigProperties;
	
	/**
     * jedis 连接池
     * @return
     */
    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(jedisConfigProperties.getMaxIdle());
        jedisPoolConfig.setMaxTotal(jedisConfigProperties.getMaxActive());
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(jedisConfigProperties.getTimeBetweenEvictionRunsMillis());
        jedisPoolConfig.setMinEvictableIdleTimeMillis(jedisConfigProperties.getMinEvictableIdleTimeMillis());
        jedisPoolConfig.setTestOnBorrow(jedisConfigProperties.isTestOnBorrow());

        return jedisPoolConfig;
    }
	
	@Bean("jedisConnectionFactory")
    public JedisConnectionFactory jedisMasterConnectionFactory() {
		return createJedisFactory(masterHost,masterPoint);
    }
	
//	@Bean("jedisSlavesConnectionFactory")
//	public JedisConnectionFactory jedisSlaveConnectionFactory() {
//		return createJedisFactory(slaveHost,slavePoint);
//	}

	@Bean("idJedisPools")
	public JedisPool jedisPool(){
    	return new JedisPool(jedisPoolConfig(),masterHost,masterPoint);
	}

	private JedisConnectionFactory createJedisFactory(String host,int port){
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration ();
		redisStandaloneConfiguration.setHostName(host);
		redisStandaloneConfiguration.setPort(port);

		JedisPoolingClientConfigurationBuilder poolConfig = (JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
		poolConfig.poolConfig(jedisPoolConfig());
		JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration, poolConfig.build());
		return factory;
	}
}
