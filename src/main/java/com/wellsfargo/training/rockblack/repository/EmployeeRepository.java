package com.wellsfargo.training.rockblack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.rockblack.model.Employee;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	public Optional<Employee> findByEmail(String email);
	
}
