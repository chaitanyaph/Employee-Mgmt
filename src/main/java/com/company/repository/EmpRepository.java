package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer>{

}
