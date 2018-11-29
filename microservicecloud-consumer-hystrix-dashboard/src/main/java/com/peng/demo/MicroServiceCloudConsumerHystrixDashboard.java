package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard//开启微服务图形化监控
@SpringBootApplication
public class MicroServiceCloudConsumerHystrixDashboard {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudConsumerHystrixDashboard.class, args);
	}

}
