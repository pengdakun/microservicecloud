package com.peng.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.peng.demo.pojo.Dept;

import feign.hystrix.FallbackFactory;

/**   
* 项目名称：microservicecloud-api   
* 类名称：DeptClientServiceFallbackFactory   
* 类描述：   
* 创建人：彭坤   
* 创建时间：2018年11月29日 下午5:30:39      
* @version 
* 
*  实现服务降级，当MICROSERVICECLOUD-DEPT微服务关闭后，客户端依旧调用，就会通过这里返回默认值，服务降级需要在客户端实现
*  
*/
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				return null;
			}
			
			@Override
			public Dept get(long id) {
				return new Dept().setDeptno(id).setDname("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭");
			}
			
			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
		
		
		
	}


}
