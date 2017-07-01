package wefun.model.po;

import java.io.Serializable;

public class BasePO implements Serializable{
	private static final long serialVersionUID = 6983997227344758161L;
	private Long updateTime;
	private Long createTime;
	public Long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}
	public Long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}
	
}
