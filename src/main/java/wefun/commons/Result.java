package wefun.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

import wefun.commons.constant.CodeAndMsg;

public class Result {
	private static final Logger LOG = LoggerFactory.getLogger("[RESULT OUT]");
	private int code;
	private String message;
	private boolean success;
	private Object data;
	public Result(){
		
	}
	public Result(int code,String message,boolean success){
		this.code=code;
		this.message=message;
		this.success = success;
	}
	public Result(int code,String message,boolean success,Object data){
		this.code=code;
		this.message=message;
		this.success = success;
		this.data = data;
	}
	public Result(CodeAndMsg codeAndMsg){
		this.code=codeAndMsg.getCode();
		this.message=codeAndMsg.getMsg();
		this.success= true;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		String info = JSON.toJSONString(data);
		LOG.info(info);
		this.data = data;
	}
}
