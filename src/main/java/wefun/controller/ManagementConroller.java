package wefun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wefun.service.ManagementService;

@RestController
@RequestMapping("/managerment")
public class ManagementConroller extends BaseController{
	@Autowired
	private ManagementService managementService;
	

}
