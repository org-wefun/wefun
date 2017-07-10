package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.ResourcePO;

public interface ResourceDAO {
	List<ResourcePO> getResourceList(ResourcePO resourcePO);
	
	Integer insert(ResourcePO resourcePO);
	
	ResourcePO get(Integer id);
    
	void update(ResourcePO resourcePO);
	
	void delete (Integer id);
}
