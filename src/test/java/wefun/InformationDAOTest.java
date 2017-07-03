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
		informationPO.setAddress("test");
		informationPO.setEmail("");
		informationPO.setPhone("");
		informationPO.setQq("");
		informationPO.setQrCodeQQ("");
		informationPO.setWechat("");
		informationPO.setQrCodeWechat("");
		System.out.println(JSON.toJSONString(informationDAO.insert(informationPO)));
	}

}
