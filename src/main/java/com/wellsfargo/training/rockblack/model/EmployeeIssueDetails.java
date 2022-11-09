package com.wellsfargo.training.rockblack.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employee_issue_details")
public class EmployeeIssueDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="issue_id")
	private Long issueId;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    private Item item;
	
	@Column(name="issue_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date issueDate;
	
	@Column(name="return_date",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date returnDate;

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
