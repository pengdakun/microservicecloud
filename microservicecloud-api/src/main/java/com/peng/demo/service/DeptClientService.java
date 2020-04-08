package com.peng.demo.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.peng.demo.pojo.Dept;

/**   
* 项目名称：microservicecloud-api   
* 类名称：DeptClientService   
* 类描述：   通过feign实现面向接口调用微服务
* 创建人：彭坤  测试一个提交了
* 创建时间：2018年11月29日 下午4:08:02      
* @version 
* 
* fallbackFactory：其中任意一个方法出现异常就会找到DeptClientServiceFallbackFactory中中对应的实现方法方法
*     
*/
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService{
	
  @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
  public Dept get(@PathVariable("id") long id);


  @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
  public List<Dept> list();


  @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
  public boolean add(Dept dept);
}
