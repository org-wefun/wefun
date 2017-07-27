package wefun.model.po;

import java.util.Date;
/**
 * 
 * @author dongyangyang
 *
 */
public class TeamPO extends BasePO{

	private static final long serialVersionUID = 4606806267159052325L;
	private int id;
	private String name;
	private String degree;
	private String qrCodeWechat;
	private String qrCodeQQ;
	private String photo;
	private String label;
	private int order;
	private Date createTime;
	private Date updateTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getQrCodeWechat() {
		return qrCodeWechat;
	}
	public void setQrCodeWechat(String qrCodeWechat) {
		this.qrCodeWechat = qrCodeWechat;
	}
	public String getQrCodeQQ() {
		return qrCodeQQ;
	}
	public void setQrCodeQQ(String qrCodeQQ) {
		this.qrCodeQQ = qrCodeQQ;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	

}
