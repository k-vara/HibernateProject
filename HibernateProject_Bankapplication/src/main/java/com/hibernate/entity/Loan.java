package com.hibernate.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Loan {
	@Id
	@Column(name="LoanId")
	//defining the loan attributes
	private int LoanId;
	private String LoanType;
	private int Amount;
	
	// Many-to-one relationship between Loan and Employee entities.
	// Specifies that each Loan is associated with a single Employee.
	// The foreign key column in the Loan table is named "employeeId" and should match the database schema.
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId") // Ensure this matches your database schema
	private Employee employee;
	
	// Many-to-one relationship between Loan and Account_Holder entities.
	// Specifies that each Loan is associated with a single Account_Holder.
	// The foreign key column in the Loan table is named "acc_holId".
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "acc_holId") // Ensure this matches your database schema
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
