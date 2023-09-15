package com.numetry.numetry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.numetry.numetry.dao.EmployeeDao;
import com.numetry.numetry.dto.Employee;
import com.numetry.numetry.dto.ResponseStructure;

@Service
public class EmployeeServices {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Employee Registered Succefully");
		structure.setBody(dao.saveEmployee(employee));
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(Employee employee) {
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setMessage("Employee Updated Succefully");
		structure.setBody(dao.updateEmployee(employee));
		structure.setCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployee(int id) {
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		Optional<Employee> recUser = dao.findEmployee(id);
		if (recUser.isPresent()) {
			structure.setMessage("Employee Found");
			structure.setBody(recUser.get());
			structure.setCode(HttpStatus.OK.value());
		}
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setBody(dao.findAll());
		structure.setMessage("All Employees are display");
		structure.setCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<String>> deleteEmployee(int id) {
		ResponseStructure<String> structure = new ResponseStructure<String>();
		Optional<Employee> recUser = dao.findEmployee(id);
		if (recUser.isPresent()) {
			dao.deleteUser(id);
			structure.setMessage("Employee Found");
			structure.setBody("employee deleted");
			structure.setCode(HttpStatus.OK.value());

		}
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);

	}

}
