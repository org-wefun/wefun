package wefun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wefun.commons.Result;
import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.model.vo.AccessReq;
import wefun.service.CommonService;

@RestController
@RequestMapping(value = "common")
public class CommonController extends BaseController{
	@Autowired
	private CommonService commonService;

	@RequestMapping(value = "/getAccess",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result getAccess(HttpServletRequest request,HttpServletResponse response,@ModelAttribute AccessReq accessReq ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(commonService.getAccess(accessReq));
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
