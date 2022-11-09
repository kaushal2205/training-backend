package com.wellsfargo.training.rockblack.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.rockblack.repository.LoanCardRepository;
import com.wellsfargo.training.rockblack.model.LoanCard;

@Service
@Transactional
public class LoanCardService {
	
	@Autowired
	private LoanCardRepository loanCardMasterRepository;
	
	public LoanCard loanCardRegister(LoanCard loanCard) {
		return loanCardMasterRepository.save(loanCard);	
	}
	
	public List<LoanCard> getAllLoanCardMaster(){
		return loanCardMasterRepository.findAll();
		
	}
	
	public LoanCard get(Long loanId){
		return loanCardMasterRepository.findById(loanId).get(); 
	}

}
