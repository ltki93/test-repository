package com.flower.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.flower.pojo.Product;
import com.flower.service.ProductService;
import com.flower.vo.SysResult;
@Controller
@RequestMapping("/product")
public class ProductController {
	@Reference(check = false)
	private ProductService productService;
	@ResponseBody
	@RequestMapping("/list")
	public SysResult findList() {
		List<Product> list=productService.findList();
		return SysResult.success(list);
	}
	@ResponseBody
	@RequestMapping("/goodItem")
	public SysResult goodItem() {
		List<Product> list=productService.goodItem();
		return SysResult.success(list);
	}
	@ResponseBody
	@RequestMapping("/findById")
	public SysResult findById(@RequestParam("id") Long id) {
		Product product=productService.findById(id);
		System.err.println(product);
		return SysResult.success(product);
	}
}
