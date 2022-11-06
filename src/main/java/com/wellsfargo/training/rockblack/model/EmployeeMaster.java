package com.wellsfargo.training.rockblack.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="employee_master")
public class EmployeeMaster {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private Long empId;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeCardDetails employeeCardDetails;
	
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeIssueDetails employeeIssueDetails;
	
	@Column(unique = true)
	private String email;

	@Column(name="password")
	private String password;
	
	public EmployeeIssueDetails getEmployeeIssueDetails() {
		return employeeIssueDetails;
	}

	public void setEmployeeIssueDetails(EmployeeIssueDetails employeeIssueDetails) {
		this.employeeIssueDetails = employeeIssueDetails;
	}

	@Column(name="first_name",nullable=false)
	private String fName;

	@Column(name="last_name")
	private String lName;

	@Column(name="designation",nullable=false)
	private String designation;

	@Column(name="department",nullable=false)
	private String dept;

	@Column(name="gender",nullable=false)
	private char gender;

	@Column(name="date_of_birth",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dob;

	@Column(name="date_of_joining",nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date doj;

	public EmployeeMaster() {
		super();
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("Email:"+email);
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Base64.Encoder encoder = Base64.getEncoder();  
        String encodedString = encoder.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        this.password = encodedString;
	}
	
	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	public EmployeeCardDetails getEmployeeCardDetails() {
		return employeeCardDetails;
	}

	public void setEmployeeCardDetails(EmployeeCardDetails employeeCardDetails) {
		this.employeeCardDetails = employeeCardDetails;
	}



}
