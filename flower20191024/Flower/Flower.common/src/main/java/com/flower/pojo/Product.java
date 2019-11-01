package com.flower.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("product")
public class Product extends BasePojo {
	private static final long serialVersionUID = -5739216531634879857L;
	@TableId(value = "id",type = IdType.INPUT)
	private Long id;
	private String title;
	private String img;
	private String productName;
	private String productDesc;
	private Long price;
	private Long num;
	private Integer status;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date end;
	

}
