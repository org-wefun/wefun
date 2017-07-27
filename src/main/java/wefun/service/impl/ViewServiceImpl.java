package wefun.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CategoryType;
import wefun.dao.mysql.CategoryDAO;
import wefun.dao.mysql.ContentDAO;
import wefun.dao.mysql.InformationDAO;
import wefun.dao.mysql.ResourceDAO;
import wefun.model.po.CategoryPO;
import wefun.model.po.ContentPO;
import wefun.model.po.InformationPO;
import wefun.model.po.ResourcePO;
import wefun.model.vo.CategoryVO;
import wefun.model.vo.ContentVO;
import wefun.service.ViewService;
@Service
public class ViewServiceImpl extends BaseServiceImpl implements ViewService{
	@Autowired
    private InformationDAO informationDAO;
	@Autowired
    private CategoryDAO gategoryDAO;
	@Autowired
	private ContentDAO contnetDAO;
	@Autowired
	private ResourceDAO resourceDAO;
	@Override
	public List<ResourcePO> getBanner() {
		CategoryPO categoryPO = new CategoryPO();
		categoryPO.setType(CategoryType.BANNER);
		CategoryPO cateGoryPO = gategoryDAO.getCategory(categoryPO);
		List<ResourcePO> resourceList = null;
		if(null != cateGoryPO){
			final int categoryId = cateGoryPO.getId();
			ResourcePO query = new ResourcePO();
			query.setCategoryId(categoryId);
			resourceList= resourceDAO.getResourceList(query);
		}
		return resourceList;
	}
	@Override
	public CategoryVO getPartner() {
		CategoryPO categoryPO = new CategoryPO();
		categoryPO.setType(CategoryType.PARTNER);
		CategoryPO categoryPODB = gategoryDAO.getCategory(categoryPO);
		
		CategoryVO categoryVO = new CategoryVO();
		final Integer categoryId = categoryPODB.getId();
		categoryVO.setName(categoryPODB.getName());
		categoryVO.setLevel(categoryPODB.getLevel());
		categoryVO.setId(categoryId);
		List<ContentPO> contentPOList = contnetDAO.getContentList(categoryId);
		categoryVO.setContentList(this.getContentVO(contentPOList));
		
		return categoryVO;
	}

	@Override
	public List<ResourcePO> getTeam() {
		// TODO Auto-generated method stub
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
		List<CategoryVO> result = new ArrayList<>();
		if(null != categoryList){
			for (CategoryPO categoryPO2 : categoryList) {
				CategoryVO categoryVO = new CategoryVO();
				final Integer categoryId = categoryPO2.getId();
				categoryVO.setName(categoryPO2.getName());
				categoryVO.setLevel(categoryPO2.getLevel());
				categoryVO.setId(categoryId);
				List<ContentPO> contentPOList = contnetDAO.getContentList(categoryId);
				categoryVO.setContentList(this.getContentVO(contentPOList));
				result.add(categoryVO);
			}
		}
		return result;
	}

	private List<ContentVO> getContentVO(List<ContentPO> contentPOList){
		List<ContentVO> resultList = new ArrayList<>();
		if(null != contentPOList){
			for (ContentPO content : contentPOList) {
				final Integer contentId = content.getId();
				ContentVO contentVO = new ContentVO();
				contentVO.setId(contentId);
				contentVO.setContent(content.getContent());
				contentVO.setTitle(content.getTitle());
				ResourcePO resourcePO = new ResourcePO();
				resourcePO.setContentId(contentId);
				contentVO.setResourceList(resourceDAO.getResourceList(resourcePO));
				resultList.add(contentVO);
			}
		}
		return resultList;
	}

	
	
}
