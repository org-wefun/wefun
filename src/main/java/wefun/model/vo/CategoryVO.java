package wefun.model.vo;

import java.util.List;
/**
 * 
 * @author Administrator
 *
 */
public class CategoryVO {
	private Integer id;
	private Integer level;
	private String name;
	private List<ContentVO> contentList;
	
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ContentVO> getContentList() {
		return contentList;
	}
	public void setContentList(List<ContentVO> contentList) {
		this.contentList = contentList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
