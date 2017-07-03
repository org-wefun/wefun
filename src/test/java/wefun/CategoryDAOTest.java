package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import wefun.dao.mysql.CategoryDAO;
import wefun.model.po.CategoryPO;

public class CategoryDAOTest extends BaseTest{
	@Autowired
	private CategoryDAO categoryDAO;
	@Test
	public void test1(){
		CategoryPO category = new CategoryPO();
		category.setLevel(1);
		category.setType(1);
		System.out.println(JSON.toJSONString(categoryDAO.getCategoryList(category)));
	}
	@Test
	public void add(){
		CategoryPO category = new CategoryPO();
		category.setName("定制礼典");
		category.setLevel(2);
		category.setOrder(3);
		category.setParentId(2);
		category.setType(2);
		categoryDAO.insert(category);
	}

}
