package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import wefun.service.ViewService;

public class ViewServiceTest extends BaseTest{
	@Autowired
	private ViewService viewService;
	@Test
   public void getNavigation(){
		System.out.println(JSON.toJSONString(viewService.getNavigation()));
   }
}
