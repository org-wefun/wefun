package wefun.commons.exception;

import wefun.commons.constant.CodeAndMsg;

public class BusinessRuntimeException extends RuntimeException {
	private int code;
	private String msg;
	private static final long serialVersionUID = 3062632128041727450L;

	public BusinessRuntimeException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	public BusinessRuntimeException(CodeAndMsg codeAndMsg) {
		super(codeAndMsg.getMsg());
		this.code = codeAndMsg.getCode();
		this.msg = codeAndMsg.getMsg();
	}
	public BusinessRuntimeException(String msg) {
		super(msg);
		this.code=1001;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
