package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroServiceCloudConfigEurekaClient7001 {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudConfigEurekaClient7001.class, args);
	}

}
