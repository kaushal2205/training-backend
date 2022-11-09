package com.wellsfargo.training.rockblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.wellsfargo.training.rockblack.repository.EmployeeRepository;
import com.wellsfargo.training.rockblack.model.Employee;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository emrepo;
	
	public Employee registerEmployee(Employee employee) {
		return emrepo.save(employee);
	}
	
	public List<Employee> getAllEmployee(){
		return emrepo.findAll();
	}
	
public Employee get(long id) {
		
		return emrepo.findById(id).get(); 
	}
	
public Optional<Employee> loginEmployee(String email) {
		
		return emrepo.findByEmail(email); 
	}

}
