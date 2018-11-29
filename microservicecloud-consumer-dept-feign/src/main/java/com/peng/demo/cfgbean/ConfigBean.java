package com.peng.demo.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {

	@Bean
	@LoadBalanced//开启客户端负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	@Bean
	public IRule myRule() {
//		return new RandomRule();//通过随机算法实现负载均衡
		return new RetryRule();//当所有微服务都存在时就用轮循，当其中一个挂掉后，调用挂掉的微服务几次后，就会放弃调用，而调用其他的微服务
	}
	
}
