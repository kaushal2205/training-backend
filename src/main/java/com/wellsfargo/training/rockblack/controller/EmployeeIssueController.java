package com.wellsfargo.training.rockblack.controller;

import com.wellsfargo.training.rockblack.model.*;
import com.wellsfargo.training.rockblack.service.EmployeeIssueDetailsService;
import com.wellsfargo.training.rockblack.service.EmployeeService;
import com.wellsfargo.training.rockblack.service.ItemService;
import com.wellsfargo.training.rockblack.service.LoanCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value="/api")
public class EmployeeIssueController {
    @Autowired
    EmployeeIssueDetailsService issueService;
    @Autowired
    private EmployeeService emService;
    @Autowired
    private ItemService itemService;
    @PostMapping("/Issue")
    public EmployeeIssueDetails register(@Validated @RequestBody Map<String,Object> request) throws Exception {
        EmployeeIssueDetails employeeIssue=new EmployeeIssueDetails();
        Long id=Long.parseLong(String.valueOf(request.get("empId")));
        Employee employee= emService.get(id);
        Long id1=Long.parseLong(String.valueOf(request.get("itemId")));
        Item item=itemService.get(id1);
        Date date=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(request.get("issueDate")));
        Date returnDate=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(request.get("returnDate")));

        employeeIssue.setEmployee(employee);
        employeeIssue.setItem(item);
        employeeIssue.setIssueDate(date);
        employeeIssue.setReturnDate(returnDate);

        issueService.registerEmployeeIssue(employeeIssue);
        return employeeIssue;

    }

    @GetMapping("/Issue")
    public List<EmployeeIssueDetails> getAllCard() {
        return issueService.getAllIssue();
    }

    @PostMapping("/findItemsByID")
    List<Item> findByID(@Validated @RequestBody Employee employee){
        return issueService.findByEmpID(employee.getEmpId());
    }

}
