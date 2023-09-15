package com.numetry.numetry.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.numetry.numetry.dto.Employee;
import com.numetry.numetry.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository repository;

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return repository.save(employee);
	}

	public Optional<Employee> findEmployee(int id) {
		return repository.findById(id);
	}

	public List<Employee> findAll() {
		return repository.findAll();
	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}

}
