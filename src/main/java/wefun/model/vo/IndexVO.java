package wefun.model.vo;

import java.util.List;

public class IndexVO extends BaseVO {
	private List<CategoryVO> categoryList;

	public List<CategoryVO> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<CategoryVO> categoryList) {
		this.categoryList = categoryList;
	}

}
