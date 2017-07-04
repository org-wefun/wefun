package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CategoryType;
import wefun.dao.mysql.CategoryDAO;
import wefun.dao.mysql.ContentDAO;
import wefun.dao.mysql.InformationDAO;
import wefun.model.po.CategoryPO;
import wefun.model.po.ContentPO;
import wefun.model.po.InformationPO;
import wefun.model.vo.CategoryVO;
import wefun.service.ViewService;
@Service
public class ViewServiceImpl extends BaseServiceImpl implements ViewService{
	@Autowired
    private InformationDAO informationDAO;
	@Autowired
    private CategoryDAO gategoryDAO;
	@Autowired
	private ContentDAO contnetDAO;
	@Override
	public CategoryVO getBanner() {
		CategoryPO categoryPO = new CategoryPO();
		categoryPO.setType(CategoryType.BANNER);
		CategoryPO cateGoryPO = gategoryDAO.getCategory(categoryPO);
		if(null != cateGoryPO){
			CategoryVO result = new CategoryVO();
			final int categoryId = cateGoryPO.getId();
			List<ContentPO> contentList = contnetDAO.getContentList(categoryId);
			if(null != contentList){
				for (ContentPO contentPO : contentList) {
					
				}
//				result.setContentList(contentList);
			}
		}
		return null;
	}

	@Override
	public InformationPO getBaseInfo() {
		return informationDAO.get();
	}

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
