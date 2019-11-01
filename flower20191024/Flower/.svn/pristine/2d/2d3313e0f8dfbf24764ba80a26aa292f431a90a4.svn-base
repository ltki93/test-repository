package com.flower.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SysResult implements Serializable{
	private static final long serialVersionUID = -4853153767248958619L;
	private Integer status; //200表示正常
	private String msg;		//服务器返回客户端的消息
	private Object data;	//主要数据
	public static SysResult success(Object object) {
		return new SysResult(200, null, object);
	}
	public static SysResult success(String msg,Object object) {
		return new SysResult(200, msg, object);
	}
	public static SysResult fail() {
		return new SysResult(201,null,null);
	}
	public static SysResult fail(String msg) {
		return new SysResult(201,msg,null);
	}
	public static SysResult success() {
		return new SysResult(200, null, null);
	}
}
