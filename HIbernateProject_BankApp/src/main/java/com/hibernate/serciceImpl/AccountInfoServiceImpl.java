package com.hibernate.serciceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.AccountInfo;
import com.hibernate.entity.Account_Holder;
import com.hibernate.entity.Branches;
import com.hibernate.service.AccountInfoService;

public class AccountInfoServiceImpl implements AccountInfoService {
	Scanner sc = new Scanner(System.in);
	Session session;
	public void insertAccountInfo(SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		 AccountInfo accounts = new  AccountInfo();

		System.out.println("Enter values for AccountInfo i.e Accountid,Account type, Balance");
		int AccountId = sc.nextInt();
		accounts.setAccountId(AccountId);
		String AccountType = sc.next();
		accounts.setAccountType(AccountType);
		int Balance=sc.nextInt();
		accounts.setBalance(Balance);
		
		session.persist(accounts);//saves the accountinfo object to the database
		transaction.commit();
		session.close();

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
				System.out.println("Enter accountType:");

				accounts.setAccountType(sc.next());
				session.saveOrUpdate(accounts);
				transaction.commit();
				break;
			case 2:
				System.out.println("Enter AccountId:");
			accounts= session.get(AccountInfo.class,sc.nextInt());                                                      
			System.out.println("Enter Balance:");

			accounts.setBalance(sc.nextInt());
			session.saveOrUpdate(accounts);
			transaction.commit();
			break;
				
			case 3:
				System.out.println("Enter AccountId:");
				accounts= session.get(AccountInfo.class,sc.nextInt());                                                      
				System.out.println("Enter BranchId:");

				int Branchid = sc.nextInt();
				Branches branch = session.get(Branches.class, Branchid);
				accounts.setBranches(branch);

				session.saveOrUpdate(accounts);
				transaction.commit();
				break;
			case 4:	
				System.out.println("Enter AccountId:");
				accounts= session.get(AccountInfo.class,sc.nextInt());                                                      
				System.out.println("Enter accholderId:");

				int accholderid = sc.nextInt();
				Account_Holder accholder = session.get(Account_Holder.class, accholderid);
				accounts.setAccHolder(accholder);

				session.saveOrUpdate(accounts);
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
		
	public void deleteAccountInfo(SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter accountId:");

		int accountId = sc.nextInt();

		 AccountInfo accounts = new  AccountInfo();
		if (accounts != null)//checks if the accountHolder exists and delets it if found
			session.delete(accounts);
		else
			System.out.println("Enter valid accountid");
		transaction.commit();
		session.close();
	
	
	}

	public void getAccountInfodetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("enter accountId:");

		int accountId = sc.nextInt();

		 AccountInfo accounts =session.get( AccountInfo.class, sc.nextInt());
		System.out.println(accounts );

		session.close();
		
	
	
	
	}


	
}
	
	
	
	
	
	
	
	
	
	
	
	
	

