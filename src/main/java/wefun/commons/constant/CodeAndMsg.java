package wefun.commons.constant;

public enum CodeAndMsg {

	// 系统通用
	REQUEST_SUCCESS(0, "请求成功"), 
	SYSTEM_EXCEPTION(-1, "系统异常，稍后再试"), 
	PARAM_NOT_NULL(1001, "参数不能为空"), 
	INVALID_PARAM(1002, "无效的参数"), 
	CANNOT_FIND_IN_DATABASE(1003, "数据库没有记录"),
	INVALID_ACCOUNT(1004, "无效的账号"), 
	NEED_LOGIN(1005,"请登录"),
	PASSWORD_ACCOUNT_ERROR(1004, "账号或密码错误");

	private String msg;
	private int code;

	private CodeAndMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static String getMsg(int code) {
		for (CodeAndMsg c : CodeAndMsg.values()) {
			if (c.getCode() == code) {
				return c.msg;
			}
		}
		return null;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
