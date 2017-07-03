package wefun.model.po;

import java.io.Serializable;
import java.util.Date;

public class BasePO implements Serializable{
	private static final long serialVersionUID = 6983997227344758161L;
	
	private Date updateTime;
	private Date createTime;
	
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
