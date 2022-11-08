package com.wellsfargo.training.rockblack.controller;

import com.wellsfargo.training.rockblack.exception.ResourceNotFoundException;
import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;
import com.wellsfargo.training.rockblack.model.EmployeeMaster;
import com.wellsfargo.training.rockblack.service.EmployeeCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class EmployeeCardController {
    @Autowired
    private EmployeeCardService emCardService;

    @PostMapping("/EmployeeCard")
    public EmployeeCardDetails employeeCardCreate(@Validated @RequestBody EmployeeCardDetails employeeCard)
    {
       return emCardService.createEmployeeCard(employeeCard);
    }
    @GetMapping("/EmployeeCard")
    public List<EmployeeCardDetails> getAllByEmail(@RequestBody String email) throws ResourceNotFoundException {
        return emCardService.getAllEmployeeCardDetails(email).orElseThrow(() ->
                new ResourceNotFoundException("Employee not found for this id :: "));
    }
}
