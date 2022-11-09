package com.wellsfargo.training.rockblack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.rockblack.model.LoanCard;
import com.wellsfargo.training.rockblack.service.LoanCardService;

@RestController
@RequestMapping(value="/api")
public class LoanCardController {
	
	@Autowired
	private LoanCardService lcmService;
	
	@PostMapping(value="/LoanCard")
	public LoanCard loanCardRegister(@Validated @RequestBody LoanCard lcmas) {
		
		LoanCard lcm= new LoanCard();
		
		lcm.setLoanType(lcmas.getLoanType());
		lcm.setDurationInYear(lcmas.getDurationInYear());
		
		lcm=lcmService.loanCardRegister(lcm);
		return lcmas;
		
	}
	@GetMapping(value="/allLoanCard")
	public List<LoanCard> getAllLoanCard(){
		return lcmService.getAllLoanCardMaster();
		
	}
	
	@GetMapping(value="/putLoanCardMaster")
	public LoanCard getLoanCard(Long loanId){
	
		return lcmService.get(loanId); 
	}
	
	

}
