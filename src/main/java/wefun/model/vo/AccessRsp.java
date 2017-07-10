package wefun.model.vo;

public class AccessRsp {

	/**
	 * OSS host
	 */
	private String host;
	/**
	 * access key
	 */
	private String accessid;
	private String policy;
	private String signature;
	/**
	 * 
	 */
	private long expire;
	/**
	 * �ļ�·��
	 */
	private String dir;
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getAccessid() {
		return accessid;
	}
	public void setAccessid(String accessid) {
		this.accessid = accessid;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public long getExpire() {
		return expire;
	}
	public void setExpire(long expire) {
		this.expire = expire;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	


}
