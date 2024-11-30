package com.hibernate.serciceImpl;

import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Bank;
import com.hibernate.entity.Branches;
import com.hibernate.service.BranchesService;

public class BranchesServiceImpl implements BranchesService {

	Scanner sc = new Scanner(System.in);
	Session session;

	public void insertBranches(SessionFactory sf){

		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		 Branches branch = new  Branches();

		System.out.println("Enter values for Branch i.e branchId,branchname and managerName");
		int branchid = sc.nextInt();
		branch.setBranchId(branchid);
		String branchname = sc.next();
		branch.setBranchName(branchname);
		String ManagerName=sc.next();
		branch.setManagerName(ManagerName);
		
		session.persist(branch);//saves the bank object to the database
		transaction.commit();
		session.close();

	}
	

	public void updateBranches(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		 Branches branch;
		try {
		while (true) {
			System.out.println("Choose option for update \n1.Update branchName\n2.Update BankId\n3.update managername\n4.Exit");

					
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter Branchid:");
				branch= session.get(Branches.class,sc.nextInt());                                                      

			     System.out.println("Enter BranchName:");

			     branch.setBranchName(sc.next());
				session.saveOrUpdate(branch);
				transaction.commit();
				break;
			case 2: 
//				System.out.println("Enter Branchid:");   
//				branch = session.get(Branches.class,sc.nextInt());     
//				System.out.println("Enter BankId:");
//				int bankid = sc.nextInt();
//			    Bank bank = session.get(Bank.class, bankid);
//			     branch.setBank(bank);
				
//			     // Update bank association
				System.out.println("Enter Branchid:");
				branch= session.get(Branches.class,sc.nextInt());             
                System.out.println("Enter new Bank ID:");
                int bankId = sc.nextInt();
                Bank bank = session.get(Bank.class, bankId);

                if (bank != null) {
                    branch.setBank(bank);
                    session.saveOrUpdate(branch);
                    transaction.commit();
                } else {
                    System.out.println("Bank not found.");
                }
                break;

                //session.saveOrUpdate(branch);
				
				
			case 3:
				System.out.println("Enter Branch id:");
				branch  = session.get(Branches.class,sc.nextInt());     

				System.out.println("Enter Manager name:");
				branch.setManagerName(sc.next());

				session.saveOrUpdate(branch);
				transaction.commit();
				break;
				
			case 4:
				System.out.println("exiting from update Branch");
	             transaction.rollback();
				
				System.exit(0);
				break;
			default:
				System.out.println("Choose the correct option");
				break;
			}
		}
		}finally {

			session.close();
		}
	
	}


	public void deleteBranches(SessionFactory sf) {
		
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter BranchId:");

		int id = sc.nextInt();

		Branches branch = session.get(Branches.class, id);
		if (branch != null)//checks if the grade exists and delets it if found
			session.delete(branch);
		else
			System.out.println("Enter valid Branch id");
		transaction.commit();
		session.close();
		
		
	}

	
	public void getBranchesdetails(SessionFactory sf) {
		session = sf.openSession();

		System.out.println("Enter Branchid:");

		int id = sc.nextInt();

		Branches branch = session.get(Branches.class, id);
		System.out.println(branch);

		session.close();
	}
}

