package com.wellsfargo.training.rockblack.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;
import com.wellsfargo.training.rockblack.model.EmployeeIssueDetails;
import com.wellsfargo.training.rockblack.repository.EmployeeCardDetailsRepository;
import com.wellsfargo.training.rockblack.repository.EmployeeIssueDetailsRepository;


@Service
@Transactional
public class EmployeeIssueDetailsService {
	@Autowired
	private EmployeeIssueDetailsRepository emrepo;
	
	public EmployeeIssueDetails registerEmployeeIssue(EmployeeIssueDetails employeeCard) {
		return emrepo.save(employeeCard);
	}
	
	public List<EmployeeIssueDetails> getAllIssue(){
		return emrepo.findAll();
	}
	
	public Optional<EmployeeIssueDetails> findByEmpID(String empId) {
		return emrepo.findByEmployee(empId); 
	}

}
