package com.wellsfargo.training.rockblack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.rockblack.model.LoanCardMaster;
import com.wellsfargo.training.rockblack.service.LoanCardMasterService;

@RestController
@RequestMapping(value="/api")
public class LoanCardMasterController {
	
	@Autowired
	private LoanCardMasterService lcmService;
	
	@PostMapping(value="/LoanCard")
	public LoanCardMaster loancardMastDetail(@Validated @RequestBody LoanCardMaster lcmas) {
		
		LoanCardMaster lcm= new LoanCardMaster();
		
		lcm.setLoanType(lcmas.getLoanType());
		lcm.setDurationInYear(lcmas.getDurationInYear());
		
		lcm=lcmService.loanCardMasterDetail(lcm);
		return lcmas;
		
	}
	@GetMapping(value="/allLoanCard")
	public List<LoanCardMaster> getAllLoanCard(){
		return lcmService.getAllLoanCardMaster();
		
	}
	
	@GetMapping(value="/putLoanCardMaster")
	public LoanCardMaster getLoanCard(Long loanId){
	
		return lcmService.get(loanId); 
	}
	
	

}
