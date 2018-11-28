package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer//开启注册中心服务端
@SpringBootApplication
public class MicroServiceCloudEureka7002 {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudEureka7002.class, args);
	}
}
