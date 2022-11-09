package com.wellsfargo.training.rockblack.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee_card_details")
public class EmployeeCardDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
    @JoinColumn(name = "loan_id",referencedColumnName = "loan_id")
    private LoanCard loanCard;
	
	@Column(name="card_issue_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date issueDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LoanCard getLoanCard() {
		return loanCard;
	}

	public void setLoanCard(LoanCard loanCard) {
		this.loanCard = loanCard;
	}

	
}
