package wefun.interceptor;

import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import wefun.commons.Result;
import wefun.commons.constant.CodeAndMsg;
import wefun.commons.util.CookieUtils;
import wefun.commons.util.PropertiesUtils;
import wefun.commons.util.ThreadLocalUtils;
import wefun.model.po.UserPO;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);
	private static Set<String> nonLoginSet = null;
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;utf-8");
        if(this.checkNonLogin(request.getRequestURI(), nonLoginSet)){
        	return true;
        }
		final String token = this.getToken(request);
		if (!StringUtils.hasText(token)) {
			Result result = new Result(CodeAndMsg.NEED_LOGIN);
			result.setSuccess(false);
			response.getWriter().write(JSON.toJSONString(result));
			return false;
		}else{
			return checkToken(token);
		}
	}

	private boolean checkNonLogin(String uri, Set<String> uris) {
		if (null == nonLoginSet) {
			nonLoginSet = PropertiesUtils.readDatasValue("nonLogin.properties");
		}
		if (nonLoginSet.contains(uri)) {
			return true;
		}
		return false;
	}

	private boolean checkToken(String token) {
		//TODO
		UserPO userPO = new UserPO();
		setUserInThreadLocal(userPO);
		return true;
	}

	private void setUserInThreadLocal(UserPO userPO) {
		ThreadLocalUtils.setObject(ThreadLocalUtils.USER_KEY, userPO);
	}

	private String getToken(HttpServletRequest request) {
		String token = null;
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(CookieUtils.TOKEN)) {
					token = cookie.getValue();
				}
			}
		}
		// 如果cookie中没有token
		if (!StringUtils.hasText(token)) {
			// 参数中获取
			token = request.getParameter(CookieUtils.TOKEN);
		}
		return token;
	}


}