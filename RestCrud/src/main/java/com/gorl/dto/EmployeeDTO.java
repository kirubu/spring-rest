package com.gorl.dto;

public class EmployeeDTO {
	
	private Long id;
	
	private String name;
	private int age;
	private String email;
	private String gender;
	private String dept;
	
	
	public EmployeeDTO() {
	}


	public EmployeeDTO(Long id, String name, int age, String email, String gender, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.gender = gender;
		this.dept = dept;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
