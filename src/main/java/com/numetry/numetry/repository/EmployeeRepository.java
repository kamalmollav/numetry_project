package com.numetry.numetry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.numetry.numetry.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
