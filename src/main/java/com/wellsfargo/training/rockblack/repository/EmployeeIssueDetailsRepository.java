package com.wellsfargo.training.rockblack.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.rockblack.model.EmployeeIssueDetails;

public interface EmployeeIssueDetailsRepository extends JpaRepository<EmployeeIssueDetails, Long>{
	public Optional<EmployeeIssueDetails> findByEmployee(String email);
}
