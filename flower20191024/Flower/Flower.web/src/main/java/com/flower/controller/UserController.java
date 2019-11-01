package com.flower.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.flower.service.UserService;
import com.flower.vo.SysResult;

@RequestMapping("/user")
@RestController
public class UserController {
	@Reference(check = false)
	private UserService userService;
	@RequestMapping("checkname")
	public SysResult checkname(String value) {
		Integer num = userService.checkname(value);
		return SysResult.success(num);
		
	}
	@RequestMapping("checktel")
	public SysResult checkntel(String value) {
		Integer num = userService.checkntel(value);
		return SysResult.success(num);
		
	}
}
