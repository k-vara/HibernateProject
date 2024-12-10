package com.hibernate.serviceImpl;

import java.util.List;


import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.hibernate.entity.Account_Holder;
import com.hibernate.service.Account_HolderService;


public class Account_HolderServiceImpl implements Account_HolderService{
   
	
	Scanner sc = new Scanner(System.in);
	Session session;

	public void insertAccount_Holder(SessionFactory sf) {

		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Account_Holder accholder = new Account_Holder();

		System.out.println("Enter values for AccountHolder i.e AccHolderid, phno,AcctHoldername and address");
		 int accHolderid = sc.nextInt();
		    accholder.setAcc_holId(accHolderid);

		    long phonenum = sc.nextLong();  // Use nextLong() for long data type
		    accholder.setPhonenum(phonenum);

		    String accHoldername = sc.next();
		    accholder.setAcc_holName(accHoldername);

		    String address = sc.next();
		    accholder.setAddress(address);
		  session.persist(accholder);//saves the grade object to the database
		   transaction.commit();
		    session.close();

	}
	public void updateAccount_Holder(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Account_Holder accholder;
		try {
			while (true) {
				System.out.println("Choose option for update \n1.Update Accholdername\n2.Update Address \n3.update phno \n4.Exit");

						
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key				                                                        
					System.out.println("Enter new AccHolderName:");

					accholder.setAcc_holName(sc.next());
					session.saveOrUpdate(accholder);
					System.out.println("--Upadeted accholdername successfully--");
					transaction.commit();
					break;

				case 2:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key					                                            
					System.out.println("Enter new Address:");

					accholder.setAddress(sc.next());
					session.saveOrUpdate(accholder);
					System.out.println("--Update address successfully--");
					break;
					
				case 3:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key
					System.out.println("Enter phno:");

					accholder.setPhonenum(sc.nextLong());
					session.saveOrUpdate(accholder);
					System.out.println("--Update phno successfully--");
					break;                                          	
				case 4:	
					
					System.out.println("--exiting from update account_holder--");
					transaction.commit();
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
	
public void deleteAccount_Holder(SessionFactory sf){

	session = sf.openSession();
	Transaction transaction = session.beginTransaction();

	System.out.println("enter accholderid:");

	int accholderid = sc.nextInt();

	Account_Holder accholder = session.get(Account_Holder.class,accholderid);
	if (accholder != null){//checks if the accountHolder exists and delets it if found
		session.delete(accholder);
	System.out.println("deleted successfully");
	}
	else {
		System.out.println("Account Holder with id" + accholderid+ "does not exits");
	}
	
	transaction.commit();
	session.close();
}
	
	
	public void getAccount_Holderdetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("Enter AccHolderid:");

		int accholderid = sc.nextInt();

		Account_Holder accholder = session.get(Account_Holder.class,accholderid);
		
		if (accholder != null){//checks if the accountHolder exists and delets it if found
			System.out.println(accholder );
			System.out.println("account hoder details retrieved successfully");
		}
		else {
			System.out.println("Account Holder with id" + accholderid+ "does not exits");
		}
		
		
		session.close();
		
		
		
	}
	
	public void getAllAccount_Holder(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from Account_Holder ");//create and execute the query to fetch all grade records
		List<Account_Holder> resultList = query.getResultList();//execute the query and retrieve the results as a list of grade objects

		for (Account_Holder AccHol : resultList)//iterate through the results and prints each grade*
			System.out.println(AccHol);

		session.close();
	}
	
}



