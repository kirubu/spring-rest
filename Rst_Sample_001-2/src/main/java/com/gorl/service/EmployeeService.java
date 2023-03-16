package com.gorl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gorl.entity.EmployeeEntity;
import com.gorl.repo.EmployeeRepo;


public interface EmployeeService {

	List<EmployeeEntity> getAllEmployees();
	
	EmployeeEntity saveEmployee(EmployeeEntity emp);
	
	EmployeeEntity getEmpById(Long id);
	
	void deleteEmp(Long id);
	
	EmployeeEntity updateEmployee(EmployeeEntity emp);
}
