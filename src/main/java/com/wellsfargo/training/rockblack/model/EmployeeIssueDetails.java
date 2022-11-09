package com.wellsfargo.training.rockblack.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee_issue_details")
public class EmployeeIssueDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="issue_id")
	private Long issueId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
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

	@Override
	public String toString() {
		return "EmployeeIssueDetails{" +
				"issueId=" + issueId +
				", employee=" + employee +
				", item=" + item +
				", issueDate=" + issueDate +
				", returnDate=" + returnDate +
				'}';
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}
