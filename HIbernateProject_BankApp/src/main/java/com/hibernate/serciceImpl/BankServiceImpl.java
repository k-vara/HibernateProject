package com.hibernate.serciceImpl;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Bank;
import com.hibernate.entity.Branches;
import com.hibernate.service.BankService;

public class BankServiceImpl implements BankService {
       
	Scanner sc = new Scanner(System.in);
	Session session;

	public void insertBank(SessionFactory sf){

		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		 Bank bank = new  Bank();

		System.out.println("Enter values for Bank i.e bankId,bankname and location");
		int bid = sc.nextInt();
		bank.setBankId(bid);
		String bname = sc.next();
		bank.setBankName(bname);
		String Addres=sc.next();
		bank.setAddress(Addres);
		
		session.persist(bank);//saves the bank object to the database
		transaction.commit();
		session.close();

	}
	

	public void updateBank(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Bank bank;
		
		try {
		while (true) {
			System.out.println("Choose option for update \n1.Update Name\n2.Update location\n3.Exit");

					
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Bank id:");
				bank = session.get(Bank.class,sc.nextInt());                                                      

			     System.out.println("Enter new Bank Name:");

				//grade.setTotalCount(sc.nextInt());
                bank.setBankName(sc.next());
				session.saveOrUpdate(bank);
				transaction.commit();
				break;
			
			case 2:
				System.out.println("Enter Bank id:");
				bank = session.get(Bank.class,sc.nextInt());                                                      

			     System.out.println("Enter new location:");

				//grade.setTotalCount(sc.nextInt());
                bank.setAddress(sc.next());
				session.saveOrUpdate(bank);
				transaction.commit();
				break;
				

			case 3:
				System.out.println("Exiting from update Bank.");
                transaction.commit(); // Ensure last transaction is committed
				System.exit(0);
				break;
			default:
				System.out.println("Choose the correct option");
				break;
			}
		}
		}catch (Exception e) {
	        // Rollback transaction if an exception occurs
	        if (session.getTransaction().isActive()) {
	            session.getTransaction().rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        session.close(); // Ensure session is closed
	    }
	}
	


	public void deleteBank(SessionFactory sf) {
		
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Bank Id:");

		int id = sc.nextInt();

		Bank bank = session.get(Bank.class, id);
		if (bank != null)//checks if the grade exists and delets it if found
			session.delete(bank);
		else
			System.out.println("Enter valid bank id");
		transaction.commit();
		session.close();
		
		
	}

	
	public void getBankdetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("Enter Bank id:");

		int id = sc.nextInt();

		Bank bank = session.get(Bank.class, id);
		System.out.println(bank);

		session.close();
	}
}
