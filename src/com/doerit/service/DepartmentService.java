package com.doerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.DepartmentMapper;
import com.doerit.model.Department;
import com.doerit.util.State;

@Service
public class DepartmentService {

	@Autowired private DepartmentMapper departmentMapper;
	
	public List<Department> viewAll() {
		return departmentMapper.findAllActive(State.ACTIVE.getDatabaseValue());
	}
	
	public int save(Department department) {
		return departmentMapper.insert(department);
	}
	
	public int update(Department department) {
		return departmentMapper.updateByPrimaryKeySelective(department);
	}
	
	public Department viewById(String id) {
		return departmentMapper.selectByPrimaryKey(id);
	}
		
}
