package com.hibernate.serciceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Account_Holder;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Loan;
import com.hibernate.entity.Transactions;
import com.hibernate.service.LoanService;

public class LoanServiceImpl implements LoanService{

	Scanner sc = new Scanner(System.in);
	Session session;
	public void insertLoan(SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		Loan loan = new  Loan();

		System.out.println("Enter values for loan i.e loanId,loan type,Amount");
		int loanId = sc.nextInt();
		loan.setLoanId(loanId);
		String loantype = sc.next();
		loan.setLoanType(loantype);
		int amount=sc.nextInt();
		loan.setAmount(amount);
		
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
				System.out.println("Enter loanId:");
				loan= session.get(Loan.class,sc.nextInt());                                                      
				System.out.println("Enter accountType:");

				loan.setLoanType(sc.next());
				session.saveOrUpdate(loan);
				transaction.commit();
				break;
			case 2:
				System.out.println("Enter loanId:");
			loan= session.get(Loan.class,sc.nextInt());                                                      
			System.out.println("Enter amount:");

			loan.setAmount(sc.nextInt());
			session.saveOrUpdate(loan);
			transaction.commit();
			break;
				
			case 3:
				System.out.println("Enter loanId:");
				loan= session.get(Loan.class,sc.nextInt());                                                      
				System.out.println("Enter empId:");

				int empid = sc.nextInt();
				Employee emp= session.get(Employee.class, empid);
				loan.setEmployee(emp);

				session.saveOrUpdate(loan);
				transaction.commit();
				break;
			case 4:	
				System.out.println("Enter loanId:");
				loan= session.get(Loan.class,sc.nextInt());                                                      
				System.out.println("Enter accholderId:");

				int accholderid = sc.nextInt();
				Account_Holder accholder = session.get(Account_Holder.class, accholderid);
				loan.setAccholder(accholder);

				session.saveOrUpdate(loan);
				transaction.commit();
				break;
		
           case 5:	
					
					System.out.println("exiting from update grade");
					System.exit(0);
					break;

				default:
					System.out.println("Choose the correct option");
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

		Loan loan = new Loan();
		if (loan!= null)//checks if the accountHolder exists and delets it if found
			session.delete(loan);
		else
			System.out.println("Enter valid loanid");
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
}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

