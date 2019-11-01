package com.flower.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("user")
public class User extends BasePojo{
	@TableId
	private Long id;
	private String name;
	private String password;
	private String tel;
	private Long status=1L;
	private String eamil;
}
