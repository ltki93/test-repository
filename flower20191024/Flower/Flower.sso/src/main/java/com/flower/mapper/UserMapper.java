package com.flower.mapper;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flower.pojo.User;

public interface UserMapper extends BaseMapper<User>{
	@Select("select count(*) from user where name=#{name}")
	Integer checkname(String name);
	@Select("select count(*) from user where tel=#{tel}")
	Integer checktel(String tel);


}
