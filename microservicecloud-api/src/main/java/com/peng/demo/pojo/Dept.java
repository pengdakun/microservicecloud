package com.peng.demo.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")//抑制编译产生的警告
//@AllArgsConstructor//全参构造方法
@NoArgsConstructor//无参构造方法
@Data//自动生成git set toString....方法
@Accessors(chain=true)//链式风格访问     dept.setDeptno(22l).setDname("小华").setDb_source("dataBases1");
public class Dept implements Serializable{
	
	private Long deptno;//主键
	private String dname;//部门名称
	private String db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public Dept(Long deptno, String dname, String db_source) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.db_source = db_source;
	}
	
}
