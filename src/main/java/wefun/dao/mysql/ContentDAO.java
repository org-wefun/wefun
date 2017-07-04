package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.ContentPO;

public interface ContentDAO {
	List<ContentPO> getContentList(Integer categoryId);
	

}
