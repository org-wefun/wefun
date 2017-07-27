package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.ContentPO;

public interface ContentDAO {              
	List<ContentPO> getContentList(Integer categoryId);
	
	Integer insert(ContentPO contentPO);
	
	ContentPO  get(Integer id);
	
	void update(ContentPO contentPO);
    
	void delete(Integer id);
}
