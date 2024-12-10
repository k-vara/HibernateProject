package com.hibernate.entity;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;



@Entity
public class AccountInfo {
	@Id
//defining accouts attributes
   private int AccountId;
   private String AccountType;
   private int Balance;
   
// Many-to-one relationship between AccountInfo and Branches entities.
// The foreign key column in the AccountInfo table is named "branch_id".
   
   @ManyToOne
   @JoinColumn(name = "branch_id")
   private Branches branches; // BranchID
// Getter method for retrieving the Account_Holder associated with this AccountInfo.  
   public Account_Holder getAccHolder() {
	return accHolder;
  }
// Setter method for setting the Account_Holder for this AccountInfo.
   public void setAccHolder(Account_Holder accHolder) {
	this.accHolder = accHolder;
 }

// Many-to-one relationship between AccountInfo and Account_Holder entities.
// The foreign key column in the AccountInfo table is named "acc_holId".

   @ManyToOne
   @JoinColumn(name = "acc_holId",referencedColumnName="acc_holId")
   private Account_Holder accHolder; // Reference to the associated Account_Holder
   
// One-to-many relationship between AccountInfo and Transactions entities.
// Transactions is the owning side with a foreign key referencing AccountInfo.

    @OneToMany(mappedBy = "accInfo", cascade = CascadeType.ALL)
 // Initializes a set to store associated Transactions entities for this AccountInfo.
    private Set<Transactions> transactions = new HashSet<>();

 // Getter method for retrieving the set of Transactions associated with this AccountInfo.
   public Set<Transactions> getTransactions() {
    return transactions;
   }

// Setter method for setting the set of Transactions for this AccountInfo.
  public void setTransactions(Set<Transactions> transactions) {
	this.transactions = transactions;
  }

  public int getAccountId() {
	return AccountId;
  }

  public void setAccountId(int accountId) {
	AccountId = accountId;
   }

  public String getAccountType() {
	return AccountType;
  }

  public void setAccountType(String accountType) {
	AccountType = accountType;
  }

  public int getBalance() {
	return Balance;
   }

 public void setBalance(int balance) {
	Balance = balance;
  }

   public Branches getBranches() {
	return branches;
  }


  public void setBranches(Branches branches) { 
	this.branches = branches;
 }



}
