package com.gorl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gorl.dto.EmployeeDTO;
import com.gorl.entity.EmployeeEntity;
import com.gorl.service.EmplService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeController {

	@Autowired
	private EmplService service; 
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee()
	{
		List<EmployeeDTO> empList = service.getAllEmployees();
		ResponseEntity<List<EmployeeDTO>> employees = new ResponseEntity<List<EmployeeDTO>>(empList, HttpStatus.OK);
		
		return employees;
	}
	
	@GetMapping("/emp/{id}")
	public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable Long id)
	{
		EmployeeDTO dto = service.getEmpById(id);
		
		ResponseEntity<EmployeeDTO> emp = new ResponseEntity<EmployeeDTO>(dto,HttpStatus.OK);
		
		return emp;
	}
	
	@PostMapping("/create")
	public EmployeeDTO createEmp(@RequestBody EmployeeEntity entity)
	{
		EmployeeDTO dto = service.createEmp(entity);
		
		return dto;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDTO> updateEmp(@PathVariable Long id, @RequestBody EmployeeEntity entity)
	{
		entity.setId(id);
		EmployeeDTO dto = service.updateEmp(entity);
		ResponseEntity<EmployeeDTO> emp = new ResponseEntity<EmployeeDTO>(dto,HttpStatus.OK);
		return emp;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmp(@PathVariable Long id)
	{
		service.deleteEmp(id);
	}
}
