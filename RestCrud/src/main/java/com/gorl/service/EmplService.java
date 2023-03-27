package com.gorl.service;

import java.util.List;

import com.gorl.dto.EmployeeDTO;
import com.gorl.entity.EmployeeEntity;

public interface EmplService {
	
	public List<EmployeeDTO> getAllEmployees();
	public EmployeeDTO getEmpById(Long id);
	
	public EmployeeDTO createEmp(EmployeeEntity emp);
	
	public EmployeeDTO updateEmp(EmployeeEntity emp);
	
	public void deleteEmp(Long id);

}
