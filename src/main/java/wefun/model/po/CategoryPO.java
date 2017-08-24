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
	private int level;
	private int parentId;
	private int order;
	/**
	 * @see wefun.commons.constant.CategoryType 
	 */
	private Integer type;
	
	private int show;
	
	private String image;
	
	private String hoverImage;
	
	private String enName;
    
	private String content;
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

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public int getShow() {
		return show;
	}

	public void setShow(int show) {
		this.show = show;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHoverImage() {
		return hoverImage;
	}

	public void setHoverImage(String hoverImage) {
		this.hoverImage = hoverImage;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
