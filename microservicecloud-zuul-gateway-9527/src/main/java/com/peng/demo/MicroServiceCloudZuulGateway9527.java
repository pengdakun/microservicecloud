package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy//开启zuul代理
@SpringBootApplication
public class MicroServiceCloudZuulGateway9527 {
	
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudZuulGateway9527.class, args);
	}
	

}
