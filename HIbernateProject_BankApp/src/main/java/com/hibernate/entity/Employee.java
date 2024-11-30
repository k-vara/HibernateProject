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
public class Employee {
	@Id
   private int EmployeeId;
  private String EmployeeName;
  private int Salary;
  
  
  @ManyToOne
  @JoinColumn(name = "branch_id", nullable = false) // Ensure this is the only reference to the branch
  private Branches branch;
  
  
  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) // changed mappedBy
  private List<Loan> loan = new ArrayList<>(); // changed to lowercase

  public List<Loan> getloan() {
      return loan;
  }

  public void setLoan(List<Loan> loan ) {
      this.loan = loan;
  }
 
 
public Branches getBranch() {
	return branch;
}
public void setBranch(Branches branch) {
	this.branch = branch;
}
public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getEmployeeName() {
	return EmployeeName;
}
public void setEmployeeName(String employeeName) {
	EmployeeName = employeeName;
}

public int getSalary() {
	return Salary;
}
public void setSalary(int salary) {
	Salary = salary;
}
  	
}
