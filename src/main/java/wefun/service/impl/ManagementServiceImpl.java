package wefun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.dao.mysql.CategoryDAO;
import wefun.dao.mysql.ContentDAO;
import wefun.dao.mysql.InformationDAO;
import wefun.model.po.InformationPO;
import wefun.service.ManagementService;
@Service
public class ManagementServiceImpl implements ManagementService{
	
	@Autowired
    private CategoryDAO gategoryDAO;
	@Autowired
	private ContentDAO contnetDAO;
	@Autowired
	private InformationDAO informationDAO;
	@Override
	public void updateBaseInfo(InformationPO informationPO) {
		if(null == informationPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		informationDAO.update(informationPO);
	}

}
