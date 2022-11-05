package com.wellsfargo.training.rockblack.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.rockblack.exception.ResourceNotFoundException;
import com.wellsfargo.training.rockblack.model.EmployeeMaster;
import com.wellsfargo.training.rockblack.service.EmployeeMasterService;

@RestController
@RequestMapping(value="/api")
public class EmployeeMasterController {

	@Autowired
	private EmployeeMasterService emService;


	@PostMapping("/Employee")
	public EmployeeMaster employeeMastDetail(@Validated @RequestBody EmployeeMaster employee) {

		EmployeeMaster em=new EmployeeMaster();
		em.setEmail(employee.getEmail());
		em.setPassword(employee.getPassword());
		em.setfName(employee.getfName());
		em.setlName(employee.getlName());
		em.setDesignation(employee.getDesignation());
		em.setDept(employee.getDept());
		em.setGender(employee.getGender());
		em.setDob(employee.getDob());
		em.setDoj(employee.getDoj());
		em=emService.registerEmployee(em);
		return employee;
	}

	@GetMapping("/Employee")
	public List<EmployeeMaster> getAllEmployeeMaster(){
		return emService.getAllEmployee();
	}

	@PostMapping("/EmployeeLogin")
	public Boolean loginDealer(@Validated @RequestBody EmployeeMaster employee) throws ResourceNotFoundException
	{
		Boolean a=false;
		String email=employee.getEmail();
		String password=employee.getPassword();
		EmployeeMaster emp = emService.loginEmployee(email).orElseThrow(() ->
		new ResourceNotFoundException("Employee not found for this id :: "));

		if(email.equals(emp.getEmail()) && password.equals(emp.getPassword()))
		{
			a=true;

		}
		return a;
	}
}
