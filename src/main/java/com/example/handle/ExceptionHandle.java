package com.example.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Result;
import com.example.exception.LoginException;
import com.example.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	private final static Logger logger=LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e) {
		if (e instanceof LoginException) {
			LoginException loginException = (LoginException) e;
			return ResultUtil.error(loginException.getCode(), loginException.getMessage());
			
		}else {
			logger.error("【系统异常】 {}", e);
			return ResultUtil.error(-1, "未知错误");
		}
	}
}
