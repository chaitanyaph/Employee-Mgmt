package com.company.service;

import java.util.List;
import java.util.Optional;

import com.company.entity.Employee;

public interface EmpService {

	public Employee createUser(Employee emp);
	
	public List<Employee> getAll();
	
	public Optional<Employee> getEmployee(Integer empId);
	
	public String updateEmployee(Integer empId, Employee emp);
	
	public String deleteEmployee(Integer empId);
}
