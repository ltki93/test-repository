package com.flower.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	@RequestMapping("/{module}")
	public String module(@PathVariable String module) {
		
		return module;
	}
}
