package com.flower.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
 
@Configuration
@PropertySource("classpath:/properties/redis.properties")
public class RedisConfig {
	/*
	 * @Value("${redis.host}") private String host;
	 * 
	 * @Value("${redis.port}") private Integer port;
	 * 
	 * @Bean public Jedis jedis() { return new Jedis(host,port); }
	 * 
	 */
	@Value("${redis.nodes}")
	private String nodes;
	@Bean
	public JedisCluster jedisCluster() {
		HashSet<HostAndPort> set=getHostPort();
		JedisCluster jedisCluster = new JedisCluster(set);
		return jedisCluster;
	}

	private HashSet<HostAndPort> getHostPort() {
		HashSet<HostAndPort> set = new HashSet<>();
		String[] msgs = nodes.split(",");
		for (String string : msgs) {
			String[] hostAndPort = string.split(":");
			HostAndPort hostPort= new HostAndPort(hostAndPort[0],Integer.parseInt(hostAndPort[1]));
			set.add(hostPort);
		}
		return set;
	}
	
	
	
	/*
	 * @Bean
	 * 
	 * @Scope("prototype") public Jedis jedis(JedisSentinelPool pool) { Jedis jedis
	 * = pool.getResource(); return jedis; }
	 */
	
	
	
	
	/*
	 * //哨兵池
	 * 
	 * @Bean public JedisSentinelPool jedisSentinelPool() { Set<String> snodes = new
	 * HashSet<>(); snodes.add(nodes); JedisSentinelPool pool=new
	 * JedisSentinelPool("mymaster",snodes); return pool; }
	 */
	
	
	
	
	
	
	
	
	
	//获取Redis分片的Jedis API
	/*
	 * @Bean public ShardedJedis shardedJedis() { return new
	 * ShardedJedis(getList(node)); } private List<JedisShardInfo> getList(String
	 * node) { List<JedisShardInfo> list = new ArrayList<>(); String[] nodes =
	 * node.split(","); for (String string : nodes) { String[] msg =
	 * string.split(":"); String host=msg[0]; int port=Integer.parseInt(msg[1]);
	 * System.out.println(host+"-----"+port); JedisShardInfo jedisShardInfo = new
	 * JedisShardInfo(host,port); list.add(jedisShardInfo); } return list; }
	 */
}
