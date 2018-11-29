package com.peng.demo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.peng.demo.pojo.Dept;
import com.peng.demo.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		return deptService.add(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}",method=RequestMethod.GET)
	@HystrixCommand(fallbackMethod="processHystrix_Get")//出现异常调用方法
	public Dept get(@PathVariable("id") Long id){
		Dept dept = deptService.get(id);
		if (dept==null) {
			throw new RuntimeException("ID:"+id+"---->数据不存在");
		}
		return dept;
	}
	
	@RequestMapping(value="/dept/list",method=RequestMethod.GET)
	public List<Dept> list(){
		return deptService.list();
	}
	
	/** 
	 * @param @return 
	 * @return Object  
	 * @Description 获得eureka中微服务的信息,暴露服务信息
	 * @author 彭坤
	 * @date 2018年11月28日 下午3:52:13
	 */
	@RequestMapping("/dept/discovery")
	public Object discovery() {
		List<String> list = client.getServices();//获得eureka中的所有微服务
		System.out.println("--------------->"+list);
		List<ServiceInstance> instances = client.getInstances("MICROSERVICECLOUD-DEPT");//获得某个微服务
		for (ServiceInstance serviceInstance : instances) {
			System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
		}
		return this.client;
	}
	
	
	/** 
	 * @param @param id
	 * @param @return 
	 * @return Dept  
	 * @Description 出现异常是的方法回调
	 * @author 彭坤
	 * @date 2018年11月29日 下午4:52:15
	 */
	public Dept processHystrix_Get(@PathVariable("id") Long id){
	   return new Dept().setDeptno(id).setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand").setDb_source("no this database in MySQL");
	}
	

}
