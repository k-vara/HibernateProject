package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class Transactions {
	@Id
	//defining the transaction attrinutes
 private int transactionId;
 private String transactiontype;
 private int amount;
 
 // Many-to-one relationship with the AccountInfo entity.
 @ManyToOne
 // Specifies the foreign key column in the Transactions table that maps to AccountInfo.
 @JoinColumn(name = "accountid") 
 private AccountInfo accInfo; // Reference to the associated AccountInfo entity.

 // Getter for transactionId.
 
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