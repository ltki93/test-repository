package com.flower.thro;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flower.vo.SysResult;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestControllerAdvice //对controller的异常生效
public class SystemException {
	
	@ExceptionHandler(RuntimeException.class)
	public SysResult exception(Throwable throwable) {
		throwable.printStackTrace();
		log.info(throwable.getMessage());
		return SysResult.fail();
	}
	
}
