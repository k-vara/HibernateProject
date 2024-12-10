package com.hibernate.serviceImpl;

import java.util.List;


import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hibernate.entity.AccountInfo;
import com.hibernate.entity.Transactions;
import com.hibernate.service.TransactionsService;



public class TransactionsServiceImpl implements TransactionsService {
	Scanner sc = new Scanner(System.in);
	Session session;
	public void insertTransactions (SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		Transactions trs = new  Transactions();

		System.out.println("Enter values for transaction i.e transactionId,Transaction type, amount");
		int  transactionId= sc.nextInt();
		trs.setTransactionId(transactionId);
		String transactionType = sc.next();
		trs.setTransactiontype(transactionType);
		int amount=sc.nextInt();
		trs.setAmount(amount);
		session.persist(trs);//saves the accountinfo object to the database
		System.out.println("------inserted successfully-----");
		transaction.commit();
		session.close();

	}
	public void updateTransactions(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Transactions trs;
		try {
		while (true) {
			System.out.println("Choose option for update \n1.Update transactionType\n2.Update amount\n3.update AccountId  \n4.Exit");

					
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter transactionId:");
				trs= session.get(Transactions.class,sc.nextInt());                                                      
				System.out.println("Enter transactionType:");

				trs.setTransactiontype(sc.next());
				session.saveOrUpdate(trs);
				System.out.println("----transactiontype updated successfully----");
				transaction.commit();
				break;
			case 2:
				System.out.println("Enter transactionId:");
				trs= session.get(Transactions.class,sc.nextInt());                                                      
				System.out.println("Enter amount:");

				trs.setAmount(sc.nextInt());
				session.saveOrUpdate(trs);
				System.out.println("-------Amount updated successfully------");
				transaction.commit();
				break;
			case 3:	
				System.out.println("Enter transactionId:");
				trs= session.get(Transactions.class,sc.nextInt());                                                      
				System.out.println("Enter accountId:");

				int accountid = sc.nextInt();
				 AccountInfo accounts = session.get( AccountInfo.class,  accountid );
				trs.setAccInfo(accounts);

				session.saveOrUpdate(trs);
				session.flush();     
				transaction.commit();       // Commit the transaction
				System.out.println("-------accountid updated successfully------");
				
				break;
		
           case 4:	
					
					System.out.println("exiting from update Transaction");
					return;
					

				default:
					System.out.println("Choose the correct option");
					break;
				}
			}
		} finally {

			session.close();
		}
	}
		
	public void deleteTransactions (SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter transactionId:");

		int transactionId = sc.nextInt();

		Transactions trs =session.get(Transactions.class,transactionId);
	
			if (trs != null){//checks if the accountHolder exists and delets it if found
				session.delete(trs);
				System.out.println("deleted successfully");
		}
		else {
			System.out.println("Bank with id " + transactionId  + "does not exist");
		}
		transaction.commit();
		session.close();
	}

	public void getTransactionsdetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("enter transactionId:");

		int transactionId = sc.nextInt();

		Transactions trs=session.get( Transactions.class, transactionId);
		if (trs != null){//checks if the accountHolder exists and delets it if found
			System.out.println(trs);
			System.out.println("---transaction details retrieved successfully---");
	}
	else {
		System.out.println("Bank with id " + transactionId  + "does not exist");
	}

		session.close();
	
	}
	public void getAllTransactions(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from Transactions");//create and execute the query to fetch all grade records
		List<Transactions> resultList = query.getResultList();//execute the query and retrieve the results as a list of grade objects

		for (Transactions t : resultList)//iterate through the results and prints each grade*
			System.out.println(t);

		System.out.println("---ALL transactiondetails retrieved successfully---");
		session.close();
	}
	
}
