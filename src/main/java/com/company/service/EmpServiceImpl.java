package com.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.company.entity.Employee;
import com.company.repository.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Override
	public Employee createUser(Employee emp) {
		
		Employee save = empRepo.save(emp);
		sendRegistrationEmail(save);
		return save;
	}
	
	 private void sendRegistrationEmail(Employee emp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(emp.getEmpEmail());
	        message.setSubject("Registration Successful");
	        message.setText("Dear " + emp.getEmpName() + ",\n\nYour registration was successful.");

	        javaMailSender.send(message);
	 }

	@Override
	public List<Employee> getAll() {
		
		List<Employee> findAll = empRepo.findAll();
		return findAll;
	}

	@Override
	public Optional<Employee> getEmployee(Integer empId) {
		
		Optional<Employee> findById = empRepo.findById(empId);
		return findById;
	}

	@Override
	public String updateEmployee(Integer empId, Employee emp) {
		
		Optional<Employee> findById = empRepo.findById(empId);
		
		if(findById.get() != null) {
			
			emp.setEmpName(emp.getEmpName());
			emp.setEmpEmail(emp.getEmpEmail());
			emp.setPassword(emp.getPassword());
			emp.setDesignation(emp.getDesignation());
			emp.setEmpCity(emp.getEmpCity());
			emp.setEmpSalary(emp.getEmpSalary());
			
			empRepo.save(emp);
			
			return "Employee Details Sucessfully Updated";
		}
		
		return null;
	}

	@Override
	public String deleteEmployee(Integer empId) {
	
		empRepo.deleteById(empId);
		return "Employee Deleted Successfully";
	}

}
