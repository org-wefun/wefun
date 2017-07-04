package wefun.dao.mysql;

import java.util.List;

import wefun.model.po.CategoryPO;

public interface CategoryDAO {
	
	public List<CategoryPO> getCategoryList(CategoryPO categoryPO);
	
	public Integer insert(CategoryPO categoryPO);
	
    public CategoryPO getCategory(CategoryPO categoryPO);

}
