package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer//开启ConfigServer集中式配置管理
@SpringBootApplication
public class MicroServiceCloudConfig3344 {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudConfig3344.class, args);
	}
	
}
