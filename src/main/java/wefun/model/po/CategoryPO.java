package wefun.model.po;
/**
 * 分类
 * @author Administrator
 *
 */
public class CategoryPO extends BasePO{
	
	private static final long serialVersionUID = 3473835975299999640L;
	private Integer id;
	private String name;
	private Integer level;
	private Integer parentId;
	private Integer order;
	/**
	 * @see wefun.commons.constant.CategoryType 
	 */
	private Integer type;
	
	
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	

}
