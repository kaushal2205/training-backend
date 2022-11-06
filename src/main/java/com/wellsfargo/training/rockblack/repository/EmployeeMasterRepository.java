package com.wellsfargo.training.rockblack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.rockblack.model.EmployeeMaster;
import java.util.Optional;

public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Long> {
	
	public Optional<EmployeeMaster> findByEmail(String email);
}
