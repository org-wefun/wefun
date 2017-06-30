package wefun.commons.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
	public static final int DEFAULT_TOKEN_ALIVE = 24 * 60 * 60;
	public static final String TOKEN = "LONIN_INFO";
	public static final String DEFAULT_PATH = "/";
	public static final String DEFAULT_DOMAIN = ".guoruyafeng.com";

	public static void addCookie(HttpServletResponse response, String value) {
		addCookie(response, value, DEFAULT_TOKEN_ALIVE);
	}

	public static void addCookie(HttpServletResponse response, String value, int alive) {
		addCookie(response, TOKEN, value, alive, DEFAULT_PATH, DEFAULT_DOMAIN);
	}

	public static void addCookie(HttpServletResponse response, String key, String val, int alive, String path,
			String domain) {
		Cookie cookie = new Cookie(key, val);
		cookie.setMaxAge(alive);
		cookie.setPath(path);
		cookie.setDomain(domain);
		response.addCookie(cookie);
	}

}
