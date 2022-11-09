package com.wellsfargo.training.rockblack.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.rockblack.exception.ResourceNotFoundException;
import com.wellsfargo.training.rockblack.model.Employee;
import com.wellsfargo.training.rockblack.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value="/api")
public class EmployeeController {

	@Autowired
	private EmployeeService emService;


	@PostMapping("/Employee")
	public Employee register(@Validated @RequestBody Employee employee) {
		System.out.println(employee.getDept());
		emService.registerEmployee(employee);
		return employee;
	}

	@GetMapping("/Employee")
	public List<Employee> getAllEmployee(){
		return emService.getAllEmployee();
	}

	@PostMapping("/EmployeeLogin")
	public Employee login(@Validated @RequestBody Employee employee) throws ResourceNotFoundException
	{
		String email=employee.getEmail();
		String password=employee.getPassword();
		Employee emp = emService.loginEmployee(email).orElseThrow(() ->
		new ResourceNotFoundException("Employee not found for this id :: "));

		if(email.equals(emp.getEmail()) && password.equals(emp.getPassword()))
		{
			return emp;
		}
		return null;
	}
}
