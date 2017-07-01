package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import wefun.dao.mysql.CategoryDAO;

public class CategoryDAOTest extends BaseTest{
	@Autowired
	private CategoryDAO categoryDAO;
	@Test
	public void test1(){
		System.out.println(JSON.toJSONString(categoryDAO.getCategoryList()));
	}
	@Test
	public void test2(){
		System.out.println(JSON.toJSONString(categoryDAO.getCategoryListByParent(2)));
	}

}
