package com.wellsfargo.training.rockblack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="loan_card_master")
public class LoanCard {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loan_id")
	private Long loanId;

	@OneToOne(mappedBy = "loanCard", cascade = CascadeType.ALL)
	@JsonIgnore
	private EmployeeCardDetails employeeCardDetails;

	@Column(name="loan_type")
	private String loanType;

	@Column(name="duration_in_year")
	private int durationInYear;


	public LoanCard() {
		super();
	}

	public Long getLoanId() {
		return loanId;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getDurationInYear() {
		return durationInYear;
	}

	public void setDurationInYear(int durationInYear) {
		this.durationInYear = durationInYear;
	}
	
	public EmployeeCardDetails getEmployeeCardDetails() {
		return employeeCardDetails;
	}

	public void setEmployeeCardDetails(EmployeeCardDetails employeeCardDetails) {
		this.employeeCardDetails=employeeCardDetails;
	}

}
