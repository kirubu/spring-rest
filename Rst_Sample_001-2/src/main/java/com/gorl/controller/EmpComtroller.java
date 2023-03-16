package com.gorl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gorl.entity.EmployeeEntity;
import com.gorl.service.EmpSeviceImple;
import com.gorl.service.EmployeeService;

//@Controller
@RestController
public class EmpComtroller {

	@Autowired
	private EmpSeviceImple empService;
	
	@RequestMapping(value = "/emplist", method = RequestMethod.GET)
	@ResponseBody
	public List<EmployeeEntity> getAllEmp()
	{
		return empService.getAllEmployees();
	}
	/*
	 * public String getAllEmp() { return "List of employees"; }
	 */
	
	@PostMapping("/createEmp")
	public EmployeeEntity createEmployee(@RequestBody EmployeeEntity emp)
	{
		return empService.saveEmployee(emp);
	}
	
	@GetMapping("/employee/{id}")
	public EmployeeEntity getEmployeeById(@PathVariable Long id)
	{
		return empService.getEmpById(id);
	}
	
	@DeleteMapping("/employeeDel/{id}")
	public void deleteEmpById(@PathVariable Long id)
	{
		empService.deleteEmp(id);
	}
	
	@PutMapping("/empupdate/{id}")
	public EmployeeEntity updateEmployee(@PathVariable Long id ,@RequestBody EmployeeEntity entity)
	{
		entity.setId(id);
		return empService.updateEmployee(entity);
		
	}
	@GetMapping("/emp/{id}")
	public String getEmpById(@PathVariable("id") Long id)
	{
		return "Emp "+id;
	}
	
	@DeleteMapping("/empdel")
	public String deleteEmp(@RequestParam Long id)
	{
		return "deleting emp"+id;
	}
	
	@PostMapping("/empadd")
	public String addEmployee(@RequestBody EmployeeEntity empEntity)
	{
		return "New employee "+empEntity;
	}
	
	@PutMapping("/updateemp/{id}")
	public EmployeeEntity updateEmp(@PathVariable("id") Long id, @RequestBody EmployeeEntity emp)
	{
		return emp;
	}
}
