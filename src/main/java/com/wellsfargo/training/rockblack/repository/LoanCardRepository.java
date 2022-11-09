package com.wellsfargo.training.rockblack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wellsfargo.training.rockblack.model.LoanCard;

public interface LoanCardRepository extends JpaRepository<LoanCard, Long> {
}
