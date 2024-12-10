package com.hibernate.entity;
import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Bank {
	 @Id
	 //defining bank attributes
	    private int bankId; 
	    private String bankName; 
	    private String address; 

	 // Defines a one-to-many relationship between Bank and Branches entities.
	 // This indicates that a single Bank entity can have multiple associated Branches entities. 	    
	    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL) 
	 // Initializes a list to store associated Branches entities for the Bank.
	    private List<Branches> branches = new ArrayList<>(); 
	    public Bank() {
	    	
	    }

	    public List<Branches> getBranches() {
	        return branches;
	    }

	    public void setBranches(List<Branches> branches) {
	        this.branches = branches;
	    }

	    public int getBankId() {
	        return bankId;
	    }

	    public void setBankId(int bankId) {
	        this.bankId = bankId;
	    }

	    public String getBankName() {
	        return bankName;
	    }

	    public void setBankName(String bankName) {
	        this.bankName = bankName;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }
	}
	
	

