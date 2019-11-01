package com.flower.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flower.pojo.Product;
public interface ProductMapper extends BaseMapper<Product> {
	@Select("select * from product")
	List<Product> findAll();
	//@Select("select id,product_name,img,price from product where status=1  order by created desc limit 0,8")
	List<Product> findList();
	List<Product> goodItem();

}
