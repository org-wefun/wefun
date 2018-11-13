package wefun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import wefun.commons.Result;
import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.model.po.InviteCode;
import wefun.service.InviteCodeService;

@RequestMapping("/invite")
@RestController
public class InviteCodeController extends BaseController {
	@Autowired
	private InviteCodeService inviteCodeService;

	@RequestMapping(value = "/add", method = { RequestMethod.POST, RequestMethod.GET })
	public Result add(HttpServletRequest request, HttpServletResponse response, @ModelAttribute InviteCode inviteCode) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			inviteCodeService.insert(inviteCode);
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

	@RequestMapping(value = "/update", method = { RequestMethod.POST, RequestMethod.GET })
	public Result update(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute InviteCode inviteCode) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			inviteCodeService.update(inviteCode);
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

	@RequestMapping(value = "/check", method = { RequestMethod.POST, RequestMethod.GET })
	public Result check(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "code") String code) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			inviteCodeService.check(code);
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
	
	@RequestMapping(value = "/delete", method = { RequestMethod.POST, RequestMethod.GET })
	public Result delete(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(name = "code") String code) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			inviteCodeService.delete(code);
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
	
	@RequestMapping(value = "/list", method = { RequestMethod.POST, RequestMethod.GET })
	public Result list(HttpServletRequest request, HttpServletResponse response) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(inviteCodeService.getList());
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
