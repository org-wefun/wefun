package wefun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wefun.commons.Result;
import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.service.PartnerService;
import wefun.service.TeamService;
import wefun.service.ViewService;

@RestController
@RequestMapping("/view")
public class ViewController extends BaseController {
	@Autowired
	private ViewService viewService;
	@Autowired
	private TeamService teamService;
	@Autowired
	private PartnerService partnerService;

	@RequestMapping(value = "/getBaseInfo", method = RequestMethod.GET)
	public @ResponseBody Result getBaseInfo(HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(viewService.getBaseInfo());
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
			LOG.error(e.getMessage(), e);
		}
		return result;
	}
	
    
	@RequestMapping(value = "/getNavigation", method = RequestMethod.GET)
	public @ResponseBody Result getNavigation(HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(viewService.getNavigation());
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
			LOG.error(e.getMessage(), e);
		}
		return result;
	}
	
	@RequestMapping(value = "/getBanner", method = RequestMethod.GET)
	public @ResponseBody Result getBanner(HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(viewService.getBanner());
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
			LOG.error(e.getMessage(), e);
		}
		return result;
	}
	
	@RequestMapping(value = "/getCatagoriaDetail", method = RequestMethod.GET)
	public @ResponseBody Result getCatagoriaDetail(HttpServletRequest request,HttpServletResponse response,@RequestParam(name="categoryId") int categoryId) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(viewService.getCatagoria(categoryId));
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
			LOG.error(e.getMessage(), e);
		}
		return result;
	}
	
	@RequestMapping(value = "/getPartnerList", method = RequestMethod.GET)
	public @ResponseBody Result getPartnerList(HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(partnerService.getPartnerList());
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
			LOG.error(e.getMessage(), e);
		}
		return result;
	}
	
	@RequestMapping(value = "/getTeamList", method = RequestMethod.GET)
	public @ResponseBody Result getTeamList(HttpServletRequest request,HttpServletResponse response) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(teamService.getTeamList());
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
			LOG.error(e.getMessage(), e);
		}
		return result;
	}
	
    
}
