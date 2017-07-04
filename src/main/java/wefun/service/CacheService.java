package wefun.service;

public interface CacheService {
	
	public void set(String key,Object value);
	
	public Object get(String key);

}
