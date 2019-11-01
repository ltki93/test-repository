package com.flower.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImgVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 180774724456314828L;
	private Integer code;
	private String msg;
	private Object data;
	
	public static ImgVo fail() {
		return new ImgVo(1,"上传失败",null);
	}
	public static ImgVo success(Object object) {
		return new ImgVo(0,"上传成功",object);
	}
}
