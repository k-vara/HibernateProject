
package com.hibernate.serviceImpl;
import java.util.List;




import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Account_Holder;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Loan;
import com.hibernate.service.LoanService;




public class LoanServiceImpl implements LoanService{

	Scanner sc = new Scanner(System.in);
	Session session;
	public void insertLoan(SessionFactory sf) {
	

		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		Loan loan = new  Loan();

		System.out.println("Enter values for loan i.e loanId,loan type,Amount, AccountHolderId, emp Id ");
		int loanId = sc.nextInt();
		loan.setLoanId(loanId);
		String loantype = sc.next();
		loan.setLoanType(loantype);
		int amount=sc.nextInt();
		loan.setAmount(amount);
		
		   System.out.println("Enter Account Holder ID:");
	        int accHolderId = sc.nextInt();
	        Account_Holder accountHolder = session.get(Account_Holder.class, accHolderId);
	        if (accountHolder == null) {
	            System.out.println("Account Holder with ID " + accHolderId + " does not exist.");
	            return;
	        }
	        loan.setAccholder(accountHolder);

	        // Collect Employee Details
	        System.out.println("Enter Employee ID:");
	        int empId = sc.nextInt();
	        Employee employee = session.get(Employee.class, empId);
	        if (employee == null) {
	            System.out.println("Employee with ID " + empId + " does not exist.");
	            return;
	        }
	        loan.setEmployee(employee);
		
		
		
		session.persist(loan);//saves the loan object to the database
		transaction.commit();
		session.close();

	}
		
public void updateLoan(SessionFactory sf) {
		
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		 Loan loan;
		try {
		while (true) {
			System.out.println("Choose option for update \n1.Update Loantype \n2.Update amount\n3.update empid\n4.update accHolderid \n5..Exit");

					
			int option = sc.nextInt();
			switch (option) {
			case 1:
				
                    System.out.println("Enter Loan ID:");
                    loan = session.get(Loan.class, sc.nextInt());
                    System.out.println("Enter New Loan Type:");
                    loan.setLoanType(sc.next());
                    session.saveOrUpdate(loan);
                    transaction.commit();
                    System.out.println("Loan Type updated successfully.");
                    break;
			case 2:
				  System.out.println("Enter Loan ID:");
                  loan = session.get(Loan.class, sc.nextInt());
                  System.out.println("Enter New Amount:");
                  loan.setAmount(sc.nextInt());
                  session.saveOrUpdate(loan);
                  transaction.commit();
                  System.out.println("Amount updated successfully.");
                  break;
				
			case 3:
				 System.out.println("Enter Loan ID:");
                 loan = session.get(Loan.class, sc.nextInt());
                 System.out.println("Enter New Employee ID:");
                 int empId = sc.nextInt();
                 Employee employee = session.get(Employee.class, empId);
                 if (employee == null) {
                     System.out.println("Employee ID not found.");
                     break;
                 }
                 loan.setEmployee(employee);
                 session.saveOrUpdate(loan);
                 transaction.commit();
                 System.out.println("Employee updated successfully.");
                 break;
				
			case 4:	
				  System.out.println("Enter Loan ID:");
                  loan = session.get(Loan.class, sc.nextInt());
                  System.out.println("Enter New Account Holder ID:");
                  int accHolId = sc.nextInt();
                  Account_Holder accountHolder = session.get(Account_Holder.class, accHolId);
                  if (accountHolder == null) {
                      System.out.println("Account Holder ID not found.");
                      break;
                  }
                  loan.setAccholder(accountHolder);
                  session.saveOrUpdate(loan);
                  transaction.commit();
                  System.out.println("Account Holder updated successfully.");
                  break;
		
				
			 case 5:
                 System.out.println("Exiting update menu.");
                 transaction.commit();
                 return;

             default:
                 System.out.println("Invalid option. Try again.");
                 break;
         }
     }
 } finally {
     session.close();
 }
}

			

	public void deleteLoan(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter loanId:");

		int loanId = sc.nextInt();

		Loan loan= session.get(Loan.class,loanId);  
		if(loan!=null) {
			System.out.println(loan);
			System.out.println("deleted successfully");
		}
		else {
			System.out.println("loan with id " + loanId + "does not exist");
		}
		transaction.commit();
		session.close();
		
		
		
	}

	
	public void getLoandetails(SessionFactory sf) {
		
		session = sf.openSession();

		System.out.println("enter loanId:");

		int loanId = sc.nextInt();

		Loan loan=session.get( Loan.class, sc.nextInt());
		System.out.println(loan );

		session.close();
	
	}
	
	public void getAllLoan(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from Loan");//create and execute the query to fetch all Loan records
		List<Loan> resultList = query.getResultList();//execute the query and retrieve the results as a list of Loan objects

		for (Loan l: resultList)//iterate through the results and prints each Loan*
			System.out.println(l);

		session.close();
	
	}
}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

