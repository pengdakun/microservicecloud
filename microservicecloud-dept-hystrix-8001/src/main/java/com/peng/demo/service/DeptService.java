package com.peng.demo.service;

import java.util.List;

import com.peng.demo.pojo.Dept;

public interface DeptService {

	public boolean add(Dept dept);
	public Dept get(Long id);
	public List<Dept> list();
	
}
