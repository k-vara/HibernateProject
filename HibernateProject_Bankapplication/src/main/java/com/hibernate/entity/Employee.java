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
public class Employee {
	@Id
//defining the emp attributes	
   private int EmployeeId;
  private String EmployeeName;
  private int Salary;
  
//Many-to-one relationship between Employee and Branches entities.
//Specifies that each Employee is associated with a single Branch.
//The foreign key column in the Employee table is named "branch_id" and is marked as non-nullable.
  @ManyToOne
  @JoinColumn(name = "branch_id", nullable = false) // Ensure this is the only reference to the branch
  private Branches branch;
  
//One-to-many relationship between Employee and Loan entities.
//Specifies that each Employee can have multiple associated Loan entries.
  @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL) 
  // Initializes a list to store associated Loan entities for this Employee
  private List<Loan> loan = new ArrayList<>(); 

//Getter method for retrieving the list of Loan objects associated with this Employee.
  public List<Loan> getloan() {
      return loan;
  }
//Setter method for setting the list of Loan objects for this Employee.
  public void setLoan(List<Loan> loan ) {
      this.loan = loan;
  }
 
 // Getter method for retrieving the Branch associated with this Employee.
   public Branches getBranch() {
	return branch;
   }
// Setter method for setting the Branch for this Employee.
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
