package com.peng.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class MySelRule{
	
	@Bean
	public IRule myRule() {
//		return new RandomRule();
//		return new RoundRobinRule();
		return new RandomRule_PK();
	}


}
