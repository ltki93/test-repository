package com.flower;
import org.mybatis.spring.annotation.MapperScan;
/**
 * spring启动类
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.flower.mapper")
public class FlowerManage {

	public static void main(String[] args) {
		SpringApplication.run(FlowerManage.class, args);
	}

}
