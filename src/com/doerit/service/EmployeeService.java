package com.doerit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.EmployeeMapper;
import com.doerit.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;
	
	public Employee viewById(String id) {
		return employeeMapper.selectByPrimaryKey(id);
	}
}
