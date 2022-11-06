package com.wellsfargo.training.rockblack.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="loan_card_master")
public class LoanCardMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loan_id")
	private Long loanId;

	@OneToOne(mappedBy = "loanCard", cascade = CascadeType.ALL)
	private EmployeeCardDetails employeeCardDetails;

	@Column(name="loan_type")
	private String loanType;

	@Column(name="duration_in_year")
	private int durationInYear;


	public LoanCardMaster() {
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
		this.employeeCardDetails = employeeCardDetails;
	}

}
