package wefun.model.po;

/**
 * 电影持久对象 对应mysql
 * @author dongyangyang
 *
 */
public class MoviePO extends BasePO{
	
	private String name;
	private String url;
	private String description;
	/**
	 *  演员 、分割
	 */
	private String players;
	private Long time;
	private String imageUrl;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlayers() {
		return players;
	}
	public void setPlayers(String players) {
		this.players = players;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
}
