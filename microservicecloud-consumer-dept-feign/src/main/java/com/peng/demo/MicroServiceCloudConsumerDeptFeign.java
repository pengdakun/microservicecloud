package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages= {"com.peng.demo"})//扫描feign所在的基础包
@ComponentScan("com.peng.demo")
@EnableEurekaClient//开启eureka客户端
@SpringBootApplication
public class MicroServiceCloudConsumerDeptFeign {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudConsumerDeptFeign.class, args);
	}
}
