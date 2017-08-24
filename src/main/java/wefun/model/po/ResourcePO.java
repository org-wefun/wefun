package wefun.model.po;
/**
 * 
 * @author dongyangyang
 *
 */
public class ResourcePO extends BasePO{
	
	private static final long serialVersionUID = -5861855559814363813L;
	
	private Integer id;
	//文件链接
	private String url;
	//类型 1=图片 2=视频
	private Integer type;
	//排序
    private Integer order;
    //所属类别
    private Integer categoryId;
    //所属类容
    private Integer contentId;
    
    private String desc;
    
    private String route;
    
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getContentId() {
		return contentId;
	}
	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
    
    
}
