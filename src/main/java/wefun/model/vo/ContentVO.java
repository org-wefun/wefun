package wefun.model.vo;

import java.util.List;

import wefun.model.po.ResourcePO;

public class ContentVO {
	private Integer id;
	private String title;
	private List<ResourcePO> resourceList;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<ResourcePO> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<ResourcePO> resourceList) {
		this.resourceList = resourceList;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

}
