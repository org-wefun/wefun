package wefun.service;

import java.util.List;

import wefun.model.po.CategoryPO;
import wefun.model.po.InformationPO;
import wefun.model.vo.CategoryVO;

public interface ViewService {
	/**
	 * 获取首页轮播图
	 * @return
	 */
	public CategoryVO getBanner();
	/**
	 * 获取基本信息
	 * @return
	 */
	public InformationPO getBaseInfo();
	
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
