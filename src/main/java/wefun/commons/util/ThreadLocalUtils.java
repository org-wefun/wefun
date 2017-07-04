package wefun.commons.util;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalUtils {

	public static final String USER_KEY = "user";
	public static final String LOCALE = "locale";
	public static final String APPLICATION = "application";
	private final static ThreadLocal<Map<String, Object>> contextHolder = new ThreadLocal<>();

	private ThreadLocalUtils() {

	}

	public static void setObject(String key, Object obj) {
		Map<String, Object> map = contextHolder.get();
		if (map == null) {
			map = new HashMap<String, Object>();
			contextHolder.set(map);
		}
		map.put(key, obj);
	}

	public static void set(Map<String, Object> map) {
		contextHolder.set(map);
	}

	public static Map<String, Object> getMap() {
		return contextHolder.get();
	}

	public static Object getObject(String key) {
		Map<String, Object> map = contextHolder.get();
		if (map == null)
			return null;
		else
			return map.get(key);
	}

	public static void remove() {
		contextHolder.remove();
	}

	public static void remove(String key) {
		Map<String, Object> map = contextHolder.get();
		if (null != map) {
			map.remove(key);
		}
	}
}
