package com.company.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	private Integer empId;
	private String empName;
	private String empEmail;
	private String password;
	private String designation;
	private String empCity;
	private Double empSalary;
	
}
