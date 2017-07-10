package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import wefun.model.po.ResourcePO;
import wefun.service.ManagementService;

public class ManagermentServiceTest extends BaseTest{
	@Autowired
	private ManagementService managermentService;
	@Test
	public void getResourceList(){
		ResourcePO resourcePO = new ResourcePO();
		resourcePO.setCategoryId(5);
		System.out.println(JSON.toJSONString(managermentService.getResourceList(resourcePO)));
	}

}
