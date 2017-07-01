package wefun.model.po;
/**
 * 内容
 * @author Administrator
 *
 */
public class ContentPO extends BasePO{
	private static final long serialVersionUID = -5003633665358079683L;
	private Integer id;
	//所属类别
	private Integer categoryId;
	//标题
	private String title;
	//内容
	private String content;
	
	private Integer order;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

	
 
}
