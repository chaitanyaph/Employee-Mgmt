package com.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.entity.Employee;
import com.company.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		
		Employee createUser = empService.createUser(emp);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable Integer empId){
		
		Optional<Employee> employee = empService.getEmployee(empId);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		List<Employee> all = empService.getAll();
		return new  ResponseEntity<List<Employee>>(all, HttpStatus.OK);
	}
	
	@PutMapping("employee/{empId}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer empId, @RequestBody Employee emp){
		
		String updateEmployee = empService.updateEmployee(empId, emp);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empId){ 
		
		String deleteEmployee = empService.deleteEmployee(empId);
		return new ResponseEntity<>(deleteEmployee, HttpStatus.OK);
	}
}
