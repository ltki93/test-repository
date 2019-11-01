package com.flower.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("product_desc")
public class ProductDesc implements Serializable{

	private static final long serialVersionUID = -2106213639622960211L;
	@TableId
	private Long productId;
	private String imgDesc;

}
