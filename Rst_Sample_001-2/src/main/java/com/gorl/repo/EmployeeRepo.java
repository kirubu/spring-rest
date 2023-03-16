package com.gorl.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gorl.entity.EmployeeEntity;



public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

}
