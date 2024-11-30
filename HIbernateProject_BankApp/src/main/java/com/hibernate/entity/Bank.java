package com.hibernate.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {
	 @Id
	    private int bankId; // changed to lowercase
	    private String bankName; // changed to lowercase
	    private String address; // changed to lowercase

	    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL) // changed mappedBy
	    private List<Branches> branches = new ArrayList<>(); // changed to lowercase

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
	
	

