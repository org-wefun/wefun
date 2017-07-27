package wefun.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import wefun.commons.Result;
import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.model.po.CategoryPO;
import wefun.model.po.ContentPO;
import wefun.model.po.InformationPO;
import wefun.model.po.ResourcePO;
import wefun.model.po.TeamPO;
import wefun.service.ManagementService;
import wefun.service.TeamService;

@RestController
@RequestMapping("/managerment")
public class ManagementConroller extends BaseController{
	@Autowired
	private ManagementService managementService;
	@Autowired
	private TeamService teamService;

	@RequestMapping(value = "/updateBaseInfo",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result updateBaseInfo(HttpServletRequest request,HttpServletResponse response,@ModelAttribute InformationPO informationPO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.updateBaseInfo(informationPO);
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
	
	@RequestMapping(value = "/getCategoryList", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result getCategoryList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute CategoryPO categoryPO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(managementService.getCategoryList(categoryPO));
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
	
	@RequestMapping(value = "/addCategory",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result addCategory(HttpServletRequest request,HttpServletResponse response,@ModelAttribute CategoryPO categoryPO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.addCategory(categoryPO);
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
	
	@RequestMapping(value = "/updateCategory",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result updateCategory(HttpServletRequest request,HttpServletResponse response, @ModelAttribute CategoryPO categoryPO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.updateCategory(categoryPO);
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

	@RequestMapping(value = "/deleteCategory", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result deleteCategory(HttpServletRequest request,HttpServletResponse response,@RequestParam(name = "id") Integer id) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.deleteCategory(id);
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
	@RequestMapping(value = "/deleteContent", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result deleteContent(HttpServletRequest request,HttpServletResponse response,@RequestParam(name = "id") Integer id) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.deleteContent(id);
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
	
	
	@RequestMapping(value = "/addContent",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result addContent(HttpServletRequest request,HttpServletResponse response,@ModelAttribute ContentPO contentPO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.addContent(contentPO);
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
	
	@RequestMapping(value = "/updateContent",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result updateContent(HttpServletRequest request,HttpServletResponse response, @ModelAttribute ContentPO contentPO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.updateContent(contentPO);
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
	
	@RequestMapping(value = "/getContentList",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result getContentList(HttpServletRequest request,HttpServletResponse response, @RequestParam(name = "categoryId") Integer categoryId) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(managementService.getContentList(categoryId));
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
	@RequestMapping(value = "/deleteResource", method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result deleteResource(HttpServletRequest request,HttpServletResponse response,@RequestParam(name = "id") Integer id) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.deleteResource(id);
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
	
	
	@RequestMapping(value = "/addResource",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result addResource(HttpServletRequest request,HttpServletResponse response,@ModelAttribute ResourcePO resourcePO ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.addResource(resourcePO);
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
	
	@RequestMapping(value = "/updateResource",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result updateResource(HttpServletRequest request,HttpServletResponse response,@ModelAttribute ResourcePO resourcePO) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			managementService.updateResource(resourcePO);
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
	
	@RequestMapping(value = "/getResourceList",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result getResourceList(HttpServletRequest request,HttpServletResponse response,@ModelAttribute ResourcePO resourcePO) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			result.setData(managementService.getResourceList(resourcePO));
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


	@RequestMapping(value = "/addTeam",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result addTeam(HttpServletRequest request,HttpServletResponse response,@ModelAttribute TeamPO team ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			teamService.insertTeam(team);
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
	
	@RequestMapping(value = "/updateTeam",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result updateTeam(HttpServletRequest request,HttpServletResponse response,@ModelAttribute TeamPO team ) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			teamService.updateTeam(team);
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
	

	@RequestMapping(value = "/getTeam",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result getTeam(HttpServletRequest request,HttpServletResponse response,@RequestParam(name = "id") int id) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			teamService.getTeam(id);
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
	
	@RequestMapping(value = "/deleteTeam",  method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody Result deleteTeam(HttpServletRequest request,HttpServletResponse response,@RequestParam(name = "id") int id) {
		Result result = new Result(CodeAndMsg.REQUEST_SUCCESS);
		try {
			teamService.deleteTeam(id);
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
