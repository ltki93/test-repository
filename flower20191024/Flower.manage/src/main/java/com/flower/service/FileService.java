package com.flower.service;

import org.springframework.web.multipart.MultipartFile;

import com.flower.pojo.WangEditor;
import com.flower.vo.ImageVo;
import com.flower.vo.ImgVo;

public interface FileService {

	ImageVo upload(MultipartFile uploadFile);

	WangEditor upLoadDescImg(MultipartFile multipartFile);

}
