package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient//开启eureka客户端
@SpringBootApplication
public class MicroServiceCloudConsumerDept80 {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudConsumerDept80.class, args);
	}
}
