package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient//开启服务发现
@EnableEurekaClient//开启eureka客户端
@SpringBootApplication
public class MicroServiceCloudDept8001 {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudDept8001.class, args);
	}

}
