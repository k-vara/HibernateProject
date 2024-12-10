package com.hibernate.serviceImpl;

import java.util.List;

import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.AccountInfo;
import com.hibernate.entity.Account_Holder;
import com.hibernate.entity.Branches;
import com.hibernate.service.AccountInfoService;
import com.hibernate.utility.InsufficientBalanceException;



public class AccountInfoServiceImpl implements AccountInfoService {
	Scanner sc = new Scanner(System.in);
	Session session;
	public void insertAccountInfo(SessionFactory sf)  throws InsufficientBalanceException{
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	try {
		 AccountInfo accounts = new  AccountInfo();

		System.out.println("Enter values for AccountInfo i.e Accountid,Account type, Balance");
		int AccountId = sc.nextInt();
		accounts.setAccountId(AccountId);//set the accountId
		String AccountType = sc.next();
		accounts.setAccountType(AccountType);//set the accounttype
		int Balance=sc.nextInt();

		int bal=testInsertAccountInfoInsufficientBalance(Balance);
		if(bal<=0) {
			//if balance is lessthan or equal zero then it will throw exception 
			throw new InsufficientBalanceException("Insufficient balance");
		}
		
		accounts.setBalance(Balance);
		session.persist(accounts);//saves the accountinfo object to the database
		transaction.commit();
		System.out.println("inserted successfully");
	}
		catch ( InsufficientBalanceException e) {
	        System.err.println(e.getMessage());  // Print error if loan already exists
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();  // Rollback if an error occurs
	        }
	        System.err.println("Error while inserting loan: " + e.getMessage());
	    } finally {
	        session.close();  // Close the session
	    }
	}
		
	 public int testInsertAccountInfoInsufficientBalance(int balance)  {
	        if (balance <= 0) {
	            return -1; // Insufficient balance
	        } else {
	            return 1; // Sufficient balance
	        }
	
	}
	
	
	 public void updateAccountInfo(SessionFactory sf) {
			session = sf.openSession();
			Transaction transaction = session.beginTransaction();
			 AccountInfo accounts;
			try {
			while (true) {
				System.out.println("Choose option for update \n1.Update accounttype \n2.Update balance\n3.update Branchid\n4.update accHolderid \n5..Exit");

						
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter AccountId:");
					accounts= session.get(AccountInfo.class,sc.nextInt());  
					
					if(accounts!=null) {
					System.out.println("Enter accountType:");
					String AccountType=sc.next();
	                accounts.setAccountType( AccountType);
	            	session.saveOrUpdate(accounts);
	            	System.out.println("--accounttype updated successfully--");
					}
					else {
						System.out.println("Account not found");
					}
					break;
				case 2:
					
					System.out.println("Enter AccountId:");
					accounts= session.get(AccountInfo.class,sc.nextInt());  
					if(accounts!=null) {
				System.out.println("Enter Balance:");
				int balance=sc.nextInt();
				accounts.setBalance(balance);
				session.saveOrUpdate(accounts);
				System.out.println("--Balance updated successfully--");
					}
					else {
						System.out.println("account not found");
					}
				break;
					
				case 3:
					System.out.println("Enter AccountId:");
					accounts= session.get(AccountInfo.class,sc.nextInt());                                                      
					System.out.println("Enter BranchId:");

					int Branchid = sc.nextInt();
					Branches branch = session.get(Branches.class, Branchid);
					accounts.setBranches(branch);

					session.saveOrUpdate(accounts);
					System.out.println("--branchid updated successfully--");
					
					break;
				 case 4:
	                 System.out.println("Enter Account ID:");
	                 accounts = session.get(AccountInfo.class, sc.nextInt());
	                 
	                 if (accounts != null) { // Check if account exists
	                   System.out.println("Enter Account Holder ID:");
	                   int accHolderId = sc.nextInt();
	                   Account_Holder accHolder = session.get(Account_Holder.class, accHolderId);
	                     if (accHolder != null) { // Check if account holder exists
	                         accounts.setAccHolder(accHolder);
	                         session.saveOrUpdate(accounts);
	         	           System.out.println("--accholderid updated successfully--");
	         	           transaction.commit();
	                        
	                     } else {
	                         System.out.println("Account Holder not found.");
	                        
	                     }
	                 } else {
	                     System.out.println("Account not found.");
	                     
	                 }
	                
	                 break;
			
	           case 5:	
						System.out.println("exiting from update AccountInfo");
						return;	

				default:
						System.out.println("Choose the correct option");
						break;
					}
			}
			}
				catch (Exception e) {
			        if (transaction != null) {
			            transaction.rollback(); // Rollback transaction in case of error
			        }
			        e.printStackTrace();
			    } finally {
			        session.close();
			    }
		}
	 
	 
	 
	 
	public void deleteAccountInfo(SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		System.out.println("enter accountId:");

		int accountId = sc.nextInt();
		 AccountInfo accounts =  session.get(AccountInfo.class, accountId);
		if (accounts != null){//checks if the accountHolder exists and delets it if found
			session.delete(accounts);
			System.out.println("---deleted successfully---");
	}
	else {
		System.out.println("Bank with id " + accountId + "does not exist");
	}
		transaction.commit();
		session.close();
	
	
	}

	public void getAccountInfodetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("enter accountId:");
		int accountId = sc.nextInt();
		 AccountInfo accounts =session.get( AccountInfo.class,accountId);
		 
		if (accounts != null){//checks if the accountHolder exists and delets it if found
			System.out.println(accounts);
			System.out.println("accountInfo deatails retrieved successfully");
	}
	else {
		System.out.println("accountswith id " + accountId + "does not exist");
	}
		session.close();
	}
	
	
	public void getAllAccountInfo(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from AccountInfo");//create and execute the query to fetch all grade records
		List<AccountInfo> resultList = query.getResultList();//execute the query and retrieve the results as a list of grade objects

		for (AccountInfo Acc : resultList)//iterate through the results and prints each grade*
			System.out.println(Acc);

		session.close();
	}
	

}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	

