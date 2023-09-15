package com.numetry.numetry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.numetry.numetry.dto.Employee;
import com.numetry.numetry.dto.ResponseStructure;
import com.numetry.numetry.services.EmployeeServices;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServices services;

	@PostMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return services.saveEmployee(employee);
	}

	@PutMapping("/employees")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee) {
		return services.updateEmployee(employee);
	}

	@GetMapping("/employees")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		return services.findAll();

	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployee(@PathVariable int id) {
		return services.findEmployee(id);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployee(@PathVariable int id) {
		return services.deleteEmployee(id);
	}

}
