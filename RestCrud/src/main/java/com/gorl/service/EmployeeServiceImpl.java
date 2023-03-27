package com.gorl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gorl.dto.EmployeeDTO;
import com.gorl.entity.EmployeeEntity;
import com.gorl.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmplService {

	@Autowired
	private EmployeeRepo empRepo;
	public List<EmployeeDTO> getAllEmployees() {
		
		List<EmployeeEntity> empListRepo =  empRepo.findAll();
		List<EmployeeDTO> empList = new ArrayList<>();
		
		for(EmployeeEntity e:empListRepo)
		{
			EmployeeDTO dto = new EmployeeDTO();
			
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setAge(e.getAge());
			dto.setEmail(e.getEmail());
			dto.setGender(e.getGender());
			dto.setDept(e.getDept());
			
			empList.add(dto);
		}
		
		return empList;
	}
	
	@Override
	public EmployeeDTO getEmpById(Long id) {
		Optional<EmployeeEntity> empEntity = empRepo.findById(id);
		
		EmployeeDTO dto = new EmployeeDTO();
		
		if(empEntity.isPresent())
		{
			
			dto.setAge(empEntity.get().getAge());
			dto.setDept(empEntity.get().getDept());
			dto.setEmail(empEntity.get().getEmail());
			dto.setGender(empEntity.get().getGender());
			dto.setId(empEntity.get().getId());
			dto.setName(empEntity.get().getName());
			return dto;
		}
		throw new RuntimeException("Employee id "+id+" not found ");
	}

	@Override
	public EmployeeDTO createEmp(EmployeeEntity emp) {
		
		EmployeeEntity entity = empRepo.save(emp);
		
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		dto.setEmail(entity.getEmail());
		dto.setGender(entity.getGender());
		dto.setDept(entity.getDept());
		
		return dto;
	}

	@Override
	public EmployeeDTO updateEmp(EmployeeEntity emp) {
		EmployeeEntity entity = empRepo.save(emp);
		
		
		EmployeeDTO dto = new EmployeeDTO();
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAge(entity.getAge());
		dto.setEmail(entity.getEmail());
		dto.setGender(entity.getGender());
		dto.setDept(entity.getDept());
		
		return dto;
	}

	@Override
	public void deleteEmp(Long id) {
		empRepo.deleteById(id);
		
	}
	
	

}
