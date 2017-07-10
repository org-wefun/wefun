package wefun.service;

import java.util.List;

import wefun.model.po.CategoryPO;
import wefun.model.po.ContentPO;
import wefun.model.po.InformationPO;
import wefun.model.po.ResourcePO;

public interface ManagementService {
	void updateBaseInfo(InformationPO informationPO);
	
	void addCategory(CategoryPO categoryPO);
	
	void updateCategory(CategoryPO categoryPO);
	
	void deleteCategory(Integer id);
	
	List<CategoryPO> getCategoryList(CategoryPO categoryPO);
	
	void addContent(ContentPO contentPO);
	
	void updateContent(ContentPO contentPO);
	
	void deleteContent(Integer id);
	
	List<ContentPO> getContentList(Integer categoryId);
	
	void addResource(ResourcePO resourcePO);
	
	void updateResource(ResourcePO resourcePO);
	
	void deleteResource(Integer id);
	
	List<ResourcePO> getResourceList(ResourcePO resourcePO);
    
}
