package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.CategoryPO;

public interface CategoryDAO {
	
	public List<CategoryPO> getCategoryList();
	
	public List<CategoryPO> getCategoryListByParent(Integer parentId);

}
