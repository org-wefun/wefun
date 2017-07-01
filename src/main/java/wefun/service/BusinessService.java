package wefun.service;

import java.util.List;

import wefun.model.po.CategoryPO;
import wefun.model.vo.CategoryVO;

public interface BusinessService {
	List<CategoryPO> getCatagoria();
    List<CategoryVO> getCatagoria(Integer id);
}
