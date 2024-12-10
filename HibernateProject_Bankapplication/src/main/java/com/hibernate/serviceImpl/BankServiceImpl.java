package com.hibernate.serviceImpl;

import java.util.List;



import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hibernate.entity.Bank;
import com.hibernate.service.BankService;

public class BankServiceImpl implements BankService {
       
	Scanner sc = new Scanner(System.in);
	Session session;

	public void insertBank(SessionFactory sf){

		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		 Bank bank = new  Bank();//creating object for the bank

		System.out.println("Enter values for Bank i.e bankId,bankname and location");
		int bid = sc.nextInt();
		bank.setBankId(bid);//set the bankid
		String bname = sc.next();
		bank.setBankName(bname);//set the bankname
		String Addres=sc.next();
		bank.setAddress(Addres);//set the address
		
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
				System.out.println("--updated bankname successfully--");
				transaction.commit();
				break;
			
			case 2:
				System.out.println("Enter Bank id:");
				bank = session.get(Bank.class,sc.nextInt());                                                      

			     System.out.println("Enter new location:");
                bank.setAddress(sc.next());
				session.saveOrUpdate(bank);
				System.out.println("--updated location successfully--");
				break;
				

			case 3:
				transaction.commit(); // Commit only when exiting
                System.out.println("Exiting update bank.");
                return; // Exit from the method
			default:
				System.out.println("Choose the correct option");
				break;
			}
		}
		}catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	         // Ensure session is closed
	    }
	}
	


	public void deleteBank(SessionFactory sf) {
		
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter Bank Id:");

		int id = sc.nextInt();

		Bank bank = session.get(Bank.class, id);
		if (bank != null){//checks if the grade exists and delets it if found
			session.delete(bank);
		System.out.println("deleted successfully");
		}
		else {
			System.out.println("Bank with id " + id + "does not exist");
		}
		transaction.commit();
		session.close();
		
		
	}

	
	public void getBankdetails(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Bank id:");
		int id = sc.nextInt();
		Bank bank = session.get(Bank.class, id);
		if(bank!=null) {
			System.out.println(bank);
			System.out.println("bank details retrieved successfully");
		}
		else {
			System.out.println("Bank with id " + id + "does not exist");
		}
		session.close();
	}
	
	public void getAllBank(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from Bank");
		List<Bank> resultList = query.getResultList();
		for (Bank bank : resultList)//iterate through the results and prints each bank
			System.out.println(bank);

		session.close();
	}
	
	
}
