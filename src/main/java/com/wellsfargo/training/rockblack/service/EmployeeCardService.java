package com.wellsfargo.training.rockblack.service;

import com.wellsfargo.training.rockblack.exception.ResourceNotFoundException;
import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;
import com.wellsfargo.training.rockblack.model.EmployeeMaster;
import com.wellsfargo.training.rockblack.model.LoanCardMaster;
import com.wellsfargo.training.rockblack.repository.EmployeeCardDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeCardService {
    @Autowired
    private EmployeeCardDetailsRepository employeeCardDetailsRepository;

      public EmployeeCardDetails createEmployeeCard(EmployeeCardDetails employeeCard){
        return employeeCardDetailsRepository.save(employeeCard);
    }

    public Optional<List<EmployeeCardDetails>> getAllEmployeeCardDetails(String email)
    {
        return employeeCardDetailsRepository.findByEmployee(email);
    }
}
