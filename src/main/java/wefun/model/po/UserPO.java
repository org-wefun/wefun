package wefun.model.po;
/**
 * 
 * @author dongyangyang
 *
 */
public class UserPO extends BasePO{
	private static final long serialVersionUID = -5597789572384988240L;
	private String account;
	private String password;
	private String realName;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
