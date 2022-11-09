package com.wellsfargo.training.rockblack.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.training.rockblack.model.Employee;
import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;
import com.wellsfargo.training.rockblack.model.LoanCard;
import com.wellsfargo.training.rockblack.service.EmployeeCardDetailsService;
import com.wellsfargo.training.rockblack.service.EmployeeService;
import com.wellsfargo.training.rockblack.service.LoanCardService;


@RestController
@RequestMapping(value="/api")
public class EmployeeCardController {
	
	@Autowired
	private EmployeeCardDetailsService cardService;
	
	@Autowired
	private EmployeeService emService;
	
	@Autowired
	private LoanCardService loanService;
	
	
	@PostMapping("/EmployeeCard")
	public EmployeeCardDetails register(@Validated @RequestBody Map<String,Object> request) throws Exception {
		
		Long id=Long.parseLong(String.valueOf(request.get("empId")));
		Employee employee= emService.get(id);
		Long id1=Long.parseLong(String.valueOf(request.get("loanId")));
		LoanCard loanCard=loanService.get(id1);
		Date date=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(request.get("issueDate")));  
		EmployeeCardDetails employeeCard=new EmployeeCardDetails();
		
		employeeCard.setEmployee(employee);
		employeeCard.setLoanCard(loanCard);
		employeeCard.setIssueDate(date);
		
//		System.out.println(employee.getEmail());
//		System.out.println(loanCard.getLoanType());	
//		System.out.println(date);
//		System.out.println(employeeCard);	
		
//		try {
//			cardService.registerEmployeeCard(employeeCard);
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
		
		cardService.registerEmployeeCard(employeeCard);
		return employeeCard;
		
	}
	
	@GetMapping("/EmployeeCard")
	public List<EmployeeCardDetails> getAllCard() {
		return cardService.getAllEmployeeCard();
	}
	
	@PostMapping("/findByID")
	 Optional<EmployeeCardDetails> findByID(@Validated @RequestBody Long id){
		return cardService.findByEmpID(id);
	}

	
}
