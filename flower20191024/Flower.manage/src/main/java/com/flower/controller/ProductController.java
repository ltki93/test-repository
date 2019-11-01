package com.flower.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flower.pojo.Product;
import com.flower.pojo.ProductDesc;
import com.flower.service.ProductService;
import com.flower.vo.SysResult;

@RestController
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("/findAll")
	public SysResult findAllProduct() {
		List<Product> products =productService.findAll();
		return SysResult.success(products);	
	}
	//product/doInserObject 
	@RequestMapping("insertProduct")
	public SysResult inserProduct(Product product,@RequestParam("imgDesc") String imgDesc) {
		productService.inserProduct(product,imgDesc);
		return SysResult.success();
	}
	@RequestMapping("deleteByIds")
	public SysResult deleteByIds(Long ids []) {
		productService.deleteByIds(ids);
		return SysResult.success();	
	}
	@RequestMapping("doFindById")
	public SysResult findById(Long id){
		Product product = productService.findById(id);
		return SysResult.success(product);	
	}
	@RequestMapping("doFindProductDesc")
	public SysResult doFindProductDesc(Long id) {
		ProductDesc productDesc=productService.doFindProductDesc(id);
		return SysResult.success(productDesc);
	}
}
