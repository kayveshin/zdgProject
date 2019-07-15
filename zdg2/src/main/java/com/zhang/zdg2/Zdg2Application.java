package com.zhang.zdg2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhang.zdg2.dao")
public class Zdg2Application {

	public static void main(String[] args) {
		SpringApplication.run(Zdg2Application.class, args);
	}

}
