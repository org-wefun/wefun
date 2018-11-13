package wefun.model.po;

public class InviteCode extends BasePO{
	private static final long serialVersionUID = 6766180537739221897L;
	private String code;
	private long expire;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getExpire() {
		return expire;
	}
	public void setExpire(long expire) {
		this.expire = expire;
	}
	

}
