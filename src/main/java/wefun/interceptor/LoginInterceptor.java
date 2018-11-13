package wefun.interceptor;

import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import wefun.service.CacheService;

public class LoginInterceptor implements HandlerInterceptor {
	private static final Logger LOG = LoggerFactory.getLogger(LoginInterceptor.class);
	private static Set<String> nonLoginSet = null;
	@Autowired
	private CacheService cacheService;
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
		return  true;
//        if(this.checkNonLogin(request.getRequestURI(), nonLoginSet)){
//        	return true;
//        }
//		final String SESSION_ID = this.getSessionId(request);
//		LOG.info("session id is : "+SESSION_ID);
//		if (!StringUtils.hasText(SESSION_ID)) {
//			Result result = new Result(CodeAndMsg.NEED_LOGIN);
//			result.setSuccess(false);
//			response.getWriter().write(JSON.toJSONString(result));
//			return false;
//		}else{
//			return checkSession(SESSION_ID);
//		}
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

	private boolean checkSession(String sessionId) {
		UserPO userPO = (UserPO)cacheService.get(sessionId);
		if(null == userPO){
			LOG.info("用户鉴权,鉴权失败,SESSION:{}",sessionId);
			return false;
		}
		LOG.info("用户鉴权:{},鉴权成功",userPO.getAccount());
		setUserInThreadLocal(userPO);
		return true;
	}

	private void setUserInThreadLocal(UserPO userPO) {
		ThreadLocalUtils.setObject(ThreadLocalUtils.USER_KEY, userPO);
	}

	private String getSessionId(HttpServletRequest request) {
		String session_id = null;
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(CookieUtils.SESSION_ID)) {
					session_id = cookie.getValue();
				}
			}
		}
		// 如果cookie中没有token
		if (!StringUtils.hasText(session_id)) {
			// 参数中获取
			session_id = request.getParameter(CookieUtils.SESSION_ID);
		}
		return session_id;
	}


}