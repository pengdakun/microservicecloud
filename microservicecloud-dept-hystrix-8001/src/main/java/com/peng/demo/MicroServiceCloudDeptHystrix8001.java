package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker//对hystrixR熔断机制的支持
@EnableDiscoveryClient//开启服务发现
@EnableEurekaClient//开启eureka客户端
@SpringBootApplication
public class MicroServiceCloudDeptHystrix8001 {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudDeptHystrix8001.class, args);
	}

}
