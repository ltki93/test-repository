package com.flower.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class ImageVo implements Serializable{
	private static final long serialVersionUID = -729541767907658074L;
	private Integer error=0; //0表示没错1表示有错
	private String url;	//图片的虚拟路径
	private Integer width; 	//	宽度
	private Integer height;	//高度
	
	//失败时调用方法
	public static ImageVo fail() {
		return new ImageVo(1,null,null,null);
	}
}
