package com.flower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.flower.pojo.WangEditor;
import com.flower.service.FileService;
import com.flower.vo.ImageVo;
import com.flower.vo.ImgVo;
@Controller
@RequestMapping("/file/")
public class FileController {
	@Autowired
	private FileService fileService;
@RequestMapping("/img")
@ResponseBody
public ImageVo upLoad(@RequestParam("file") MultipartFile uploadFile) {
	ImageVo resopnse=fileService.upload(uploadFile);
	return resopnse;
	
}
@RequestMapping("/descImg")
@ResponseBody
public WangEditor upLoadDescImg(@RequestParam("myFile") MultipartFile multipartFile){
	WangEditor wang=fileService.upLoadDescImg(multipartFile);
	return wang;	
}
}
