package com.hibernate.entity;

import java.util.ArrayList;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Branches {
	 @Id
	 //defining branch attributes
	    private int branchId; 
	    private String branchName; 
	    private String managerName; 

	    
	 // Many-to-one relationship between Branches and Bank entities.
	 // Indicates that each Branch is associated with a single Bank.
	    @ManyToOne
	    @JoinColumn(name = "bank_id") // Specifies the foreign key column in the Branches table that references the Bank entity
	    private Bank bank;
	    
	 // One-to-many relationship between Branches and AccountInfo entities.
	 // Specifies that each Branch can have multiple AccountInfo entries associated with it.
	    @OneToMany(mappedBy = "branches", cascade = CascadeType.ALL) 
	 // Initializes a list to store associated AccountInfo entities for this Branch.
	    private List<AccountInfo> AccountInfo = new ArrayList<>(); 

	    public Branches() {
	    	
	    }
	 // Getter method for retrieving the list of AccountInfo associated with this Branch.
	    public List<AccountInfo> getAccountInfo() {
	        return AccountInfo;
	    }
	 // Setter method for setting the list of AccountInfo for this Branch.
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
