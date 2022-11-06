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
@Table(name="item_master")
public class ItemMaster {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="item_id")
	private Long itemId;
	
	@OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private EmployeeIssueDetails employeeIssueDetails;
	
	@Column(name="item_description")
	private String itemDescription;
	
	@Column(name="issue_status")
	private char itemStatus;
	
	public EmployeeIssueDetails getEmployeeIssueDetails() {
		return employeeIssueDetails;
	}

	public void setEmployeeIssueDetails(EmployeeIssueDetails employeeIssueDetails) {
		this.employeeIssueDetails = employeeIssueDetails;
	}

	@Column(name="item_make")
	private String itemMake;
	
	@Column(name="Item_category")
	private String itemCategory;
	
	@Column(name="item_valuation")
	private int itemValuation;

	public ItemMaster() {
		super();
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public char getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(char itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemMake() {
		return itemMake;
	}

	public void setItemMake(String itemMake) {
		this.itemMake = itemMake;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public int getItemValuation() {
		return itemValuation;
	}

	public void setItemValuation(int itemValuation) {
		this.itemValuation = itemValuation;
	}

	
	
}
