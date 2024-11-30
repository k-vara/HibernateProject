package com.hibernate.serciceImpl;

import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.AccountInfo;
import com.hibernate.entity.Account_Holder;
import com.hibernate.entity.Bank;
import com.hibernate.entity.Loan;
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
				System.out.println("Choose option for update \n1.Update Accholdername\n2.Update Address\n3.Update AccountId\n4.phno \n5.Exit");

						
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key				                                                        
					System.out.println("Enter AccHolderName:");

					accholder.setAcc_holName(sc.next());
					session.saveOrUpdate(accholder);
					transaction.commit();
					break;

				case 2:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key					                                            
					System.out.println("Enter Address:");

					accholder.setAddress(sc.next());
					session.saveOrUpdate(accholder);
					transaction.commit();
					break;
					
				case 3:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key
					System.out.println("Enter phno:");

					accholder.setPhonenum(sc.nextInt());
					session.saveOrUpdate(accholder);
					transaction.commit();
					break;                                          

				case 4:
					System.out.println("Enter accHolderid:");

					accholder = session.get(Account_Holder.class, sc.nextInt());//session.get method is used to fetch the accholder object using its primary key
					System.out.println("Enter AccountId");

					int Accountid = sc.nextInt();
					AccountInfo Accounts = session.get(AccountInfo.class, Accountid);
					accholder.setAccounts(null);
					if (Accounts != null) {
	                    // Add the branch to the bank's list of branches
						accholder.getaccounts().add(Accounts);
	                    session.saveOrUpdate(accholder);
	                    transaction.commit();
	                } else {
	                    System.out.println("Branches not found.");
	                }

					session.saveOrUpdate(accholder);
					transaction.commit();
					break;
					
				case 5:	
					
					System.out.println("exiting from update account_holder");
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
	
public void deleteAccount_Holder(SessionFactory sf){

	session = sf.openSession();
	Transaction transaction = session.beginTransaction();

	System.out.println("enter accholderid:");

	int accholderid = sc.nextInt();

	Account_Holder accholder = new Account_Holder();
	if (accholder != null)//checks if the accountHolder exists and delets it if found
		session.delete(accholder);
	else
		System.out.println("Enter valid accholder id");
	
	
	transaction.commit();
	session.close();
}
	
	
	public void getAccount_Holderdetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("Enter AccHolderid:");

		int accholderid = sc.nextInt();

		Account_Holder accholder = session.get(Account_Holder.class, sc.nextInt());
		System.out.println(accholder );

		session.close();
		
		
		
	}
	


}
