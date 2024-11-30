package com.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transactions {
	@Id
 private int transactionId;
 private String transactiontype;
 private int amount;
 
 
 @ManyToOne
 @JoinColumn(name = "accountid") // Foreign key in Transactions table
 private AccountInfo accInfo;



public int getTransactionId() {
	return transactionId;
}


public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}


public String getTransactiontype() {
	return transactiontype;
}


public void setTransactiontype(String transactiontype) {
	this.transactiontype = transactiontype;
}


public int getAmount() {
	return amount;
}


public void setAmount(int amount) {
	this.amount = amount;
}


public AccountInfo getAccInfo() {
    return accInfo;
}

public void setAccInfo(AccountInfo accInfo) {
    this.accInfo = accInfo;
}
}