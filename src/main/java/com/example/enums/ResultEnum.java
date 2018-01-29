package com.example.enums;

public enum ResultEnum {

	UNKNOW_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	NOT_EXIST(100,"该帐号不存在"),
	ERROR(200,"账号或密码不正确"),
	ILLEGAL(300,"输入字符非法");
	
	private Integer code;
	private String msg;
	private ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
	
}
