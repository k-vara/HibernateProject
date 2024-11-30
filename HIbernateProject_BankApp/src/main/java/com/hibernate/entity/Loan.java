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
public class Loan {
	@Id
	private int LoanId;
	private String LoanType;
	private int Amount;
	
	@ManyToOne
    @JoinColumn(name = "employeeId") // ensure this matches your database schema
    private Employee employee;
	
	@ManyToOne
	  @JoinColumn(name = "acc_holId") // Ensure this is the only reference to the branch
	  private Account_Holder Accholder;
	  
	
	
	
	
	public int getLoanId() {
		return LoanId;
	}
	public void setLoanId(int loanId) {
		LoanId = loanId;
	}
	public String getLoanType() {
		return LoanType;
	}
	public void setLoanType(String loanType) {
		LoanType = loanType;
	}
	
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount= amount;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Account_Holder getAccholder() {
		return Accholder;
	}
	public void setAccholder(Account_Holder Accholder) {
		this.Accholder = Accholder;
	}
	
	
		
}
