package com.gorl.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gorl.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

}
