package wefun;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import wefun.dao.mysql.InformationDAO;
import wefun.model.po.InformationPO;

public class InformationDAOTest extends BaseTest{
	@Autowired
	private InformationDAO informationDAO;
	@Test
	public void get(){
		System.out.println(JSON.toJSONString(informationDAO.get()));
	}
	@Test
	public void add(){
		InformationPO informationPO = new InformationPO();
		informationPO.setAddress("武成大街2号莱茵春天1709");
		informationPO.setEmail("3258613042@qq.com");
		informationPO.setPhone("028-86612315");
		informationPO.setQq("3258613042");
		informationPO.setQrCodeQQ("");
		informationPO.setWechat("国儒雅风(公众号)");
		informationPO.setQrCodeWechat("");
		informationPO.setId(1);
		informationDAO.update(informationPO);
	}

}
