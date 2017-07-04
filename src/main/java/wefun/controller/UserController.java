package wefun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wefun.commons.Result;
import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.commons.util.CookieUtils;
import wefun.model.po.UserPO;
import wefun.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Result getDetail(HttpServletRequest request,HttpServletResponse response,@ModelAttribute UserPO userPO) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			final String key = userService.login(userPO);
			if(StringUtils.hasText(key)){
				CookieUtils.addCookie(response, key);
			}
		} catch (BusinessRuntimeException be) {
			result.setCode(be.getCode());
			result.setMessage(be.getMessage());
			result.setSuccess(false);
			LOG.info(be.getMessage(), be);
		} catch (Throwable e) {
			e.printStackTrace();
			result.setCode(CodeAndMsg.SYSTEM_EXCEPTION.getCode());
			result.setMessage(CodeAndMsg.SYSTEM_EXCEPTION.getMsg());
			result.setSuccess(false);
			LOG.info(e.getMessage(), e);
		}
		return result;
	}

}
