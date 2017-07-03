package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import wefun.commons.constant.CategoryType;
import wefun.dao.mysql.CategoryDAO;
import wefun.dao.mysql.ContentDAO;
import wefun.dao.mysql.InformationDAO;
import wefun.model.po.CategoryPO;
import wefun.model.po.InformationPO;
import wefun.model.po.ResourcePO;
import wefun.service.BusinessService;
import wefun.service.IndexService;

public class IndexServiceImpl implements IndexService{
	@Autowired
    private InformationDAO informationDAO;
	@Autowired
    private CategoryDAO gategoryDAO;
	@Autowired
	private ContentDAO contnetDAO;
	@Override
	public List<ResourcePO> getBanner() {
		CategoryPO categoryPO = new CategoryPO();
		categoryPO.setType(CategoryType.BANNER);
		gategoryDAO.getCategoryList(categoryPO);
		return null;
	}

	@Override
	public InformationPO getBaseInfo() {
		return informationDAO.get();
	}

}
