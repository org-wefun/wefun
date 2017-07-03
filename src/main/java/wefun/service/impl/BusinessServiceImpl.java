package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CategoryType;
import wefun.dao.mysql.CategoryDAO;
import wefun.dao.mysql.ContentDAO;
import wefun.model.po.CategoryPO;
import wefun.model.vo.CategoryVO;
import wefun.service.BusinessService;
@Service
public class BusinessServiceImpl implements BusinessService{
	@Autowired
    private CategoryDAO gategoryDAO;
	@Autowired
	private ContentDAO contnetDAO;
	@Override
	public List<CategoryPO> getNavigation() {
		CategoryPO categoryPO = new CategoryPO();
		categoryPO.setLevel(1);
		categoryPO.setType(CategoryType.NAVIGATION);
		return gategoryDAO.getCategoryList(categoryPO);
	}

	@Override
	public List<CategoryVO> getCatagoria(Integer id) {
		CategoryPO categoryPO = new CategoryPO();
		categoryPO.setLevel(1);
		categoryPO.setType(2);
		categoryPO.setParentId(id);
		List<CategoryPO> categoryList = gategoryDAO.getCategoryList(categoryPO);
		if(null != categoryList){
			for (CategoryPO categoryPO2 : categoryList) {
				//TODO 
			}
		}
		return null;
	}

}
