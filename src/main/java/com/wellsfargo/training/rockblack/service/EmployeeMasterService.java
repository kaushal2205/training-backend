package com.wellsfargo.training.rockblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.wellsfargo.training.rockblack.repository.EmployeeMasterRepository;
import com.wellsfargo.training.rockblack.model.EmployeeMaster;

@Service
@Transactional
public class EmployeeMasterService {
	
	@Autowired
	private EmployeeMasterRepository emrepo;
	
	public EmployeeMaster registerEmployee(EmployeeMaster employee) {
		return emrepo.save(employee);
	}
	
	public List<EmployeeMaster> getAllEmployee(){
		return emrepo.findAll();
	}
	
public Optional<EmployeeMaster> loginEmployee(String email) {
		
		return emrepo.findByEmail(email); 
	}

}
