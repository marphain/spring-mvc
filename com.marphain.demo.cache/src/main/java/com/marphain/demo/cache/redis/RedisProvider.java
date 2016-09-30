package com.marphain.demo.cache.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisProvider
{
	public void save()
	{
//		redisTemplate.setHashValueSerializer(hashValueSerializer);
	}
	
	public static void main(String[] args)
	{
		try 
		{
			
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
			RedisTemplate redisTemplate = (RedisTemplate) context.getBean("redisTemplate");
			redisTemplate.opsForValue().set("test", "value1");
			System.out.println(redisTemplate.opsForValue().get("test"));
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
	}

}
