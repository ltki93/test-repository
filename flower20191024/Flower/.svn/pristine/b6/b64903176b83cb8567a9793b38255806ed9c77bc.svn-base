package com.flower.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.flower.pojo.WangEditor;
import com.flower.vo.ImageVo;


@Service
@com.alibaba.dubbo.config.annotation.Service
@PropertySource("classpath:/properties/image.properties")
public class FileServiceImpl implements FileService{
	@Value("${imagelocalDirPath}")
	private String localDir;//="D:/software/imge/";
	@Value("${imageurlDirPath}")//="http://image.flower.com/";
	private String urlDir;
	private int width;
	private int height;
	@Override
	public ImageVo upload(MultipartFile uploadFile) {
		System.out.println(localDir);
		System.out.println(urlDir);
		//获取源文件
		String filename = uploadFile.getOriginalFilename();
		//拆串
		filename = filename.toLowerCase();
		if (!filename.matches(".+//.(png|jpeg|gif|jpg)$")) {
			ImageVo.fail();
		}
		System.out.println("校验成功");
		try {
			BufferedImage read = ImageIO.read(uploadFile.getInputStream());
			width = read.getWidth();
			height = read.getHeight();
			System.err.println(width+"*"+height);
			if (width==0||height==0) {
				return ImageVo.fail();
			}
			System.out.println("经过校验该文件是图片");
		} catch (Exception e) {
			e.printStackTrace();
			return ImageVo.fail();
		}
		String dateDir=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		String dirFilePath=localDir+dateDir;
		File file = new File(dirFilePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String uuid = UUID.randomUUID().toString();
		String fileType = filename.substring(filename.lastIndexOf("."));
		String realFileName=uuid+fileType;
		String realFilePath=dirFilePath+realFileName;
		try {
			uploadFile.transferTo(new File(realFilePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return ImageVo.fail();
		}
		String url=urlDir+dateDir+realFileName;
		return new ImageVo(0, url, width, height);
	}
	/**
	 *富文本编辑框图片上传 
	 * 
	 * 
	 * 
	 */

	@Override
	public WangEditor upLoadDescImg(MultipartFile uploadFile) {
		System.out.println(localDir);
		System.out.println(urlDir);
		//获取源文件
		String filename = uploadFile.getOriginalFilename();
		//拆串
		filename = filename.toLowerCase();
		if (!filename.matches(".+//.(png|jpeg|gif|jpg)$")) {
			ImageVo.fail();
		}
		System.out.println("校验成功");
		try {
			BufferedImage read = ImageIO.read(uploadFile.getInputStream());
			width = read.getWidth();
			height = read.getHeight();
			System.err.println(width+"*"+height);
			if (width==0||height==0) {
				return WangEditor.fail();
			}
			System.out.println("经过校验该文件是图片");
		} catch (Exception e) {
			e.printStackTrace();
			return WangEditor.fail();
		}
		String dateDir=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
		String dirFilePath=localDir+dateDir;
		File file = new File(dirFilePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		String uuid = UUID.randomUUID().toString();
		String fileType = filename.substring(filename.lastIndexOf("."));
		String realFileName=uuid+fileType;
		String realFilePath=dirFilePath+realFileName;
		try {
			uploadFile.transferTo(new File(realFilePath));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return WangEditor.fail();
		}
		String url=urlDir+dateDir+realFileName;
		String[] imgPath= {url};
		return WangEditor.success(imgPath);
	}
	

}
