package wefun.model.po;

public class InformationPO extends BasePO{
	
	private static final long serialVersionUID = 4596212800246750075L;
	private Integer id;
	private String email;
	private String address;
	private String phone;
	private String wechat;
	private String qq;
	private String qrCodeWechat;
	private String qrCodeQQ;
	private String aboutUs;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
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
	public String getAboutUs() {
		return aboutUs;
	}
	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

}
