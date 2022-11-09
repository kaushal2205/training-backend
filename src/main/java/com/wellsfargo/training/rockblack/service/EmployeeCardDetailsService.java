package com.wellsfargo.training.rockblack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.wellsfargo.training.rockblack.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;
import com.wellsfargo.training.rockblack.repository.EmployeeCardDetailsRepository;


@Service
@Transactional
public class EmployeeCardDetailsService {
	@Autowired
	private EmployeeCardDetailsRepository emrepo;
	
	public EmployeeCardDetails registerEmployeeCard(EmployeeCardDetails employeeCard) {
		return emrepo.save(employeeCard);
	}
	
	public List<EmployeeCardDetails> getAllEmployeeCard(){
		return emrepo.findAll();
	}
	
	public List<EmployeeCardDetails> findByEmpID(long empId) {

		List<EmployeeCardDetails> allCards=emrepo.findAll();
		List<EmployeeCardDetails> resultList=new ArrayList<>();
		for(EmployeeCardDetails card:allCards)
		{
			if(card.getEmployee().getEmpId()==empId)
				resultList.add( card);
		}
		return resultList;
	}

}
