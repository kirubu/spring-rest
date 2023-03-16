package com.gorl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gorl.entity.EmployeeEntity;
import com.gorl.repo.EmployeeRepo;

@Service
public class EmpSeviceImple implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		
		return empRepo.findAll();
	}


	@Override
	public EmployeeEntity saveEmployee(EmployeeEntity emp) {
		EmployeeEntity empSave = empRepo.save(emp);
		
		EmployeeEntity empReturn = new EmployeeEntity();
		empReturn.setId(empSave.getId());
		empReturn.setName(empSave.getName());
		empReturn.setEmail(empSave.getEmail());
		empReturn.setAge(empSave.getAge());
		empReturn.setDept(empSave.getDept());
		empReturn.setGender(empSave.getGender());
		empReturn.setCreatedAt(empSave.getCreatedAt());
		empReturn.setUpdatedAt(empSave.getUpdatedAt());
		
		return empReturn;
	}


	@Override
	public EmployeeEntity getEmpById(Long id) {
		Optional<EmployeeEntity> empEntity = empRepo.findById(id);
		
		if(empEntity.isPresent())
			return empEntity.get();
		throw new RuntimeException("Employee id "+id+" not found ");
	}
	
	@Override
	public void deleteEmp(Long id)
	{
		empRepo.deleteById(id);
	}


	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity emp) {
		
		return empRepo.save(emp);
	}
}
