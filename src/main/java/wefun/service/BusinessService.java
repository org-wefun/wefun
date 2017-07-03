package wefun.service;

import java.util.List;

import wefun.model.po.CategoryPO;
import wefun.model.vo.CategoryVO;

public interface BusinessService {
	/**
	 * 获取一级菜单
	 * @return
	 */
	List<CategoryPO> getNavigation();
	/**
	 * 获取菜单下的所有资源
	 * @param id
	 * @return
	 */
    List<CategoryVO> getCatagoria(Integer id);
    
}
