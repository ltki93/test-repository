package com.flower.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flower.pojo.Product;

public interface ProductMapper extends BaseMapper<Product> {
	@Select("select * from product")
	List<Product> findAll();

}
