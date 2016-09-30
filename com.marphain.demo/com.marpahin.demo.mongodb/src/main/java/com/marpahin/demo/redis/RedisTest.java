package com.marpahin.demo.redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class RedisTest
{
	public static void main(String[] args)
	{
		Jedis jedis = null;
		try 
		{
			jedis = new Jedis("192.168.56.101");
			
			//String类型
			jedis.set("firstKey", "hello world");
			System.out.println(jedis.get("firstKey"));
			
			//hash类型
			Map<String, String> hMap = new HashMap<String, String>();
			hMap.put("key1", "value1");
			hMap.put("key2", "value2");
			jedis.hmset("hash", hMap);
			System.out.println(jedis.hgetAll("hash"));
			
			//list列表
			String[] list = {"list1", "list2"};
			jedis.lpush("list", list);
			System.out.println(jedis.lrange("list", 0, 10));
			
			//set集合
			String[] members = {"set1", "set2"};
			jedis.sadd("set", members);
			System.out.println(jedis.smembers("set"));
			
			//
		} 
		catch (Exception e) 
		{
			if (jedis != null)
			{
				jedis.close();
			}
		}
	}

}
