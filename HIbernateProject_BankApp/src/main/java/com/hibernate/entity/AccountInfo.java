package com.hibernate.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;


import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class AccountInfo {
	@Id
   private int AccountId;
   private String AccountType;
   private int Balance;
   
   @ManyToOne
   @JoinColumn(name = "branch_id")
   private Branches branches; // BranchID
   
   public Account_Holder getAccHolder() {
	return accHolder;
}

public void setAccHolder(Account_Holder accHolder) {
	this.accHolder = accHolder;
}



@ManyToOne
   @JoinColumn(name = "acc_holId",referencedColumnName="acc_holId")
   private Account_Holder accHolder;  // Acc_HolderID
   
  
@OneToMany(mappedBy = "accInfo", cascade = CascadeType.ALL)
private Set<Transactions> transactions = new HashSet<>();

public Set<Transactions> getTransactions() {
    return transactions;
}

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
