package com.peng.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.peng.rule.MySelRule;

//针对MICROSERVICECLOUD-DEPT微服务，使用自定义配置类算法，进行负载均衡
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelRule.class)
@EnableEurekaClient//开启eureka客户端
@SpringBootApplication
public class MicroServiceCloudConsumerDept80 {
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCloudConsumerDept80.class, args);
	}
}
