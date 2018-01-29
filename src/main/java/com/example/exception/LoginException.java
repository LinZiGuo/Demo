package com.example.exception;

import com.example.enums.ResultEnum;

public class LoginException extends RuntimeException {

	private Integer code;

	public LoginException(ResultEnum resultEnum) {
		super(resultEnum.getMsg());
		this.code = resultEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
