package com.wellsfargo.training.rockblack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.rockblack.model.EmployeeCardDetails;

public interface EmployeeCardDetailsRepository extends JpaRepository<EmployeeCardDetails, Long> {
	public Optional<EmployeeCardDetails> findByEmployee(String email);
}
