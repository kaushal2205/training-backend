package com.wellsfargo.training.rockblack.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;

public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, Long> {
	
	public List<EmployeeCardDetails> findAll();
	
	public Optional<EmployeeCardDetails> findByEmployee(long id);
}
