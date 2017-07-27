package wefun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wefun.commons.constant.CodeAndMsg;
import wefun.commons.exception.BusinessRuntimeException;
import wefun.dao.mysql.CategoryDAO;
import wefun.dao.mysql.ContentDAO;
import wefun.dao.mysql.InformationDAO;
import wefun.dao.mysql.ResourceDAO;
import wefun.model.po.CategoryPO;
import wefun.model.po.ContentPO;
import wefun.model.po.InformationPO;
import wefun.model.po.ResourcePO;
import wefun.service.ManagementService;
@Service
public class ManagementServiceImpl implements ManagementService{
	@Autowired
    private CategoryDAO gategoryDAO;
	@Autowired
	private ContentDAO contnetDAO;
	@Autowired
	private ResourceDAO resourceDAO;
	@Autowired
	private InformationDAO informationDAO;
	@Override
	public void updateBaseInfo(InformationPO informationPO) {
		if(null == informationPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		informationDAO.update(informationPO);
	}
	
	public void getAccess(){
		
	}

	@Override
	public void addCategory(CategoryPO categoryPO) {
		if(null == categoryPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		gategoryDAO.insert(categoryPO);
		
	}

	@Override
	public void updateCategory(CategoryPO categoryPO) {
		if(null == categoryPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		final Integer id = categoryPO.getId();
		if(null == id){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		CategoryPO categoryDB= gategoryDAO.getCategory(categoryPO);
		if(null == categoryDB){
			throw new BusinessRuntimeException(CodeAndMsg.CANNOT_FIND_IN_DATABASE); 
		}
		categoryDB.setLevel(categoryPO.getLevel());
		categoryDB.setName(categoryPO.getName());
		categoryDB.setOrder(categoryPO.getOrder());
		categoryDB.setParentId(categoryPO.getParentId());
		categoryDB.setType(categoryPO.getType());
		gategoryDAO.update(categoryPO);
		
	}

	@Override
	public List<CategoryPO> getCategoryList(CategoryPO categoryPO) {
		if(null == categoryPO ){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		return gategoryDAO.getCategoryList(categoryPO);
	}

	@Override
	public void deleteCategory(Integer id) {
		if(null == id){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		gategoryDAO.delete(id);
	}

	@Override
	public void addContent(ContentPO contentPO) {
		if(null == contentPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		contnetDAO.insert(contentPO);
	}

	@Override
	public void updateContent(ContentPO contentPO) {
		if(null == contentPO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		Integer id = contentPO.getId();
		if(null == id){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		ContentPO contentDB = contnetDAO.get(id);
		if(null == contentDB){
			throw new BusinessRuntimeException(CodeAndMsg.CANNOT_FIND_IN_DATABASE);
		}
		contentDB.setCategoryId(contentPO.getCategoryId());
		contentDB.setContent(contentPO.getContent());
		contentDB.setOrder(contentPO.getOrder());
		contentDB.setTitle(contentPO.getTitle());
		contnetDAO.update(contentPO);
	}

	@Override
	public void deleteContent(Integer contentId) {
		if(null == contentId){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		contnetDAO.delete(contentId);
	}

	@Override
	public List<ContentPO> getContentList(Integer categoryId) {
		if(null == categoryId){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		return contnetDAO.getContentList(categoryId);
	}

	@Override
	public void addResource(ResourcePO resourcePO) {
		if(null == resourcePO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		resourceDAO.insert(resourcePO);
	}

	@Override
	public void updateResource(ResourcePO resourcePO) {
		if(null == resourcePO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		final Integer id = resourcePO.getId();
		if(id == null){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		ResourcePO resourceDB = resourceDAO.get(id);
		if(null == resourceDB){
			throw new BusinessRuntimeException(CodeAndMsg.CANNOT_FIND_IN_DATABASE);
		}
		resourceDB.setCategoryId(resourcePO.getCategoryId());
		resourceDB.setContentId(resourcePO.getContentId());
		resourceDB.setDesc(resourcePO.getDesc());
		resourceDB.setOrder(resourcePO.getOrder());
		resourceDB.setType(resourcePO.getType());
		resourceDB.setUrl(resourcePO.getUrl());
		
		resourceDAO.update(resourcePO);
		
	}

	@Override
	public void deleteResource(Integer id) {
		if(null == id){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		resourceDAO.delete(id);
	}

	@Override
	public List<ResourcePO> getResourceList(ResourcePO resourcePO) {
		if(null == resourcePO){
			throw new BusinessRuntimeException(CodeAndMsg.PARAM_NOT_NULL);
		}
		return resourceDAO.getResourceList(resourcePO);
	}

}
