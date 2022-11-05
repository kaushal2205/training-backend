package com.wellsfargo.training.rockblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.rockblack.repository.LoanCardMasterRepository;
import com.wellsfargo.training.rockblack.model.LoanCardMaster;

@Service
@Transactional
public class LoanCardMasterService {
	
	@Autowired
	private LoanCardMasterRepository loanCardMasterRepository;
	
	public LoanCardMaster loanCardMasterDetail(LoanCardMaster loanCard) {
		return loanCardMasterRepository.save(loanCard);	
	}
	
	public List<LoanCardMaster> getAllLoanCardMaster(){
		return loanCardMasterRepository.findAll();
		
	}
	
	public LoanCardMaster get(Long loanId){
		return loanCardMasterRepository.findById(loanId).get(); 
	}

}
