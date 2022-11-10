package com.wellsfargo.training.rockblack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.wellsfargo.training.rockblack.model.Item;
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
	
	public EmployeeIssueDetails registerEmployeeIssue(EmployeeIssueDetails employeeIssue) {
		return emrepo.save(employeeIssue);
	}
	
	public List<EmployeeIssueDetails> getAllIssue(){
		return emrepo.findAll();
	}
	
	public List<Item> findByEmpID(Long empId) {
		List<EmployeeIssueDetails> allIssues=emrepo.findAll();
		List<Item> resultList=new ArrayList<>();

		for(EmployeeIssueDetails issue:allIssues)
		{
			if(issue.getEmployee().getEmpId()==empId)
			{
				resultList.add(issue.getItem());
			}
		}
		return resultList;
	}

}
