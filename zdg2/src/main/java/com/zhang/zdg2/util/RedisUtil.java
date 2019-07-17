package com.zhang.zdg2.util;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
	@Resource
	RedisTemplate<String, Object> redisTemplate;
	
	//缓存失效
	public boolean expire(String key,long time) {
		if(time>0) {
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
			return true;
		}
		return false;
	}
	
	//是否存在
	public boolean hasKey(String key) {
		return redisTemplate.hasKey(key);
	}
	
	//获取
	public Object get(String key) {
		return redisTemplate.opsForValue().get(key);
		
	}
	
	//储存
	public boolean set(String key,Object value) {
		redisTemplate.opsForValue().set(key,value);
		return true;
	}
	
	
	//将list放入缓存
	public boolean Lset(String key,List<Object> value) {
		redisTemplate.opsForList().rightPushAll(key, value);
		return true;
	}
	
	//取出list中的某一元素
	public Object Lget(String key,int index) {
		return redisTemplate.opsForList().index(key, index);
	}
	
	//移除list中的某个值
	public boolean Lremove(String key) {
		redisTemplate.delete(key);
		return true;
	}
	
}
