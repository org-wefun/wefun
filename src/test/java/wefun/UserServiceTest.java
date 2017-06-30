package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import wefun.service.UserService;

public class UserServiceTest extends BaseTest{
	@Autowired
	private UserService userService;
	@Test
	public void test(){
		System.out.println(JSON.toJSONString(userService.getUser("admin")));
	}

}
