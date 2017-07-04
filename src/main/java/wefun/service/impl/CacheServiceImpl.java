package wefun.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import wefun.service.CacheService;
@Service
public class CacheServiceImpl implements CacheService{
	
	public static Map<String,Object> cacheMap = new ConcurrentHashMap<String,Object>();

	@Override
	public void set(String key, Object value) {
		cacheMap.put(key, value);
	}

	@Override
	public Object get(String key) {
		return cacheMap.get(key);
	}

}
