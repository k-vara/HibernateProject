package com.hibernate.entity;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Branches {
	 @Id
	    private int branchId; // changed to lowercase
	    private String branchName; // changed to lowercase
	    private String managerName; // changed to lowercase

	    @ManyToOne
	    @JoinColumn(name = "bank_id") // ensure this matches your database schema
	    private Bank bank;
	    
	    @OneToMany(mappedBy = "branches", cascade = CascadeType.ALL) // changed mappedBy
	    private List<AccountInfo> AccountInfo = new ArrayList<>(); // changed to lowercase

	    public Branches() {
	    	
	    }

	    public List<AccountInfo> getAccountInfo() {
	        return AccountInfo;
	    }

	    public void setBranches(List<AccountInfo> accInfo) {
	        this.AccountInfo = accInfo;
	    }

	    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL) // changed mappedBy
	    private List<Employee> Emp = new ArrayList<>(); // changed to lowercase

	    public List<Employee> getEmp() {
	        return Emp;
	    }

	    public void setEmployee(List<Employee>  Emp ) {
	        this.Emp = Emp;
	    }
	    
	    

	    public int getBranchId() {
	        return branchId;
	    }

	    public void setBranchId(int branchId) {
	        this.branchId = branchId;
	    }

	    public String getBranchName() {
	        return branchName;
	    }

	    public void setBranchName(String branchname) {
	        this.branchName = branchname;
	    }

	    public String getManagerName() {
	        return managerName;
	    }

	    public void setManagerName(String managerName) {
	        this.managerName = managerName;
	    }

	    public Bank getBank() {
	        return bank;
	    }

	    public void setBank(Bank bank) {
	        this.bank = bank;
	    }
	
}
