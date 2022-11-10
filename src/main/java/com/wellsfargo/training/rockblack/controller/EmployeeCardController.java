package com.wellsfargo.training.rockblack.controller;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.wellsfargo.training.rockblack.model.Employee;
import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;
import com.wellsfargo.training.rockblack.model.EmployeeIssueDetails;
import com.wellsfargo.training.rockblack.model.Item;
import com.wellsfargo.training.rockblack.model.LoanCard;
import com.wellsfargo.training.rockblack.service.EmployeeCardDetailsService;
import com.wellsfargo.training.rockblack.service.EmployeeIssueDetailsService;
import com.wellsfargo.training.rockblack.service.EmployeeService;
import com.wellsfargo.training.rockblack.service.ItemService;
import com.wellsfargo.training.rockblack.service.LoanCardService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api")
public class EmployeeCardController {
	
	@Autowired
	private EmployeeIssueDetailsService issueService;
	
	@Autowired
	private EmployeeCardDetailsService cardService;
	
	@Autowired
	private EmployeeService emService;
	
	@Autowired
	private LoanCardService loanService;
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping("/master")
	public void addAll(@Validated @RequestBody Map<String,Object> request) throws ParseException {
		Long id=Long.parseLong(String.valueOf(request.get("empId")));
		System.out.println(request);
		String description=String.valueOf(request.get("description"));
		String category=String.valueOf(request.get("category"));
		String make=String.valueOf(request.get("make"));
		int value=Integer.parseInt(String.valueOf(request.get("value")));
		Item item=new Item();
		item.setItemCategory(category);
		item.setItemMake(make);
		item.setItemDescription(description);
		item.setItemValuation(value);
		item.setItemStatus('P');
		itemService.itemRegister(item);
		
		LoanCard lc =new LoanCard();
		lc.setLoanType(category);
		int duration;
		if( value > 10000) {
			duration =5;
		}else {
			duration =2;
		}
		
		lc.setDurationInYear(duration);

		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();  
		SimpleDateFormat formatter2=new SimpleDateFormat("yyyy-MM-dd");
		Date date =formatter2.parse(now.format(dtf));
		lc.setIssueDate(date);
		loanService.loanCardRegister(lc);

		EmployeeCardDetails employeeCard=new EmployeeCardDetails();
		Employee employee= emService.get(id);
		employeeCard.setEmployee(employee);
		employeeCard.setLoanCard(lc);
		employeeCard.setIssueDate(date);
		cardService.registerEmployeeCard(employeeCard);
		
		
		EmployeeIssueDetails issue=new EmployeeIssueDetails();
		issue.setEmployee(employee);
		issue.setItem(item);
		issue.setIssueDate(date);
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR, duration);
		Date returnDate =c.getTime();
		issue.setReturnDate(returnDate);
		issueService.registerEmployeeIssue(issue);
		
		
	}
	
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
	
	@PostMapping("/findLoanByEmpID")
	 List<LoanCard> findByEmpID(@Validated @RequestBody Employee employee){
		return cardService.findByEmpID(employee.getEmpId());
	}

	
}
