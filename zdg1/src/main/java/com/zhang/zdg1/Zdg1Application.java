package com.zhang.zdg1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhang.zdg1.dao")
public class Zdg1Application {

	public static void main(String[] args) {
		SpringApplication.run(Zdg1Application.class, args);
	}
	
}
