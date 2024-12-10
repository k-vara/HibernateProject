package com.hibernate.serviceImpl;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
		//Transaction transaction = session.beginTransaction();
		 Branches branch;
		
			 Transaction transaction = null;
			    
			    try {
			        transaction = session.beginTransaction();
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
				System.out.println("--Branch name updated successfully--");
				break;
			case 2: 
	     // Update bank association
				System.out.println("Enter Branchid:");
				branch= session.get(Branches.class,sc.nextInt());             
                System.out.println("Enter new Bank ID:");
                int bankId = sc.nextInt();
                Bank bank = session.get(Bank.class, bankId);

                if (bank != null) {
                    branch.setBank(bank);
                    session.saveOrUpdate(branch);
                    transaction.commit();
                    System.out.println("--Bank id updated successfully--");
                } else {
                    System.out.println("Bank not found.");
                }
               
                break;
                
			case 3:
				System.out.println("Enter Branch id:");
				branch  = session.get(Branches.class,sc.nextInt());     

				if(branch!=null) {
				System.out.println("Enter new Manager name:");
				branch.setManagerName(sc.next());
			
				session.saveOrUpdate(branch);
				System.out.println("--Manager name upadated succesfully--");
				}
				 transaction.commit();
				break;
				
			case 4:
        
				System.out.println("--Exiting update branches.--");    
                return; // Exit from the method
               
			default:
                System.out.println("Choose a valid option.");
                break;
        }
    }
} catch (Exception e) {
    if (transaction != null) {
        transaction.rollback(); // Rollback in case of any error
    }
    e.printStackTrace();
} finally {
    session.close(); // Ensure session is closed at the end
}
}


	public void deleteBranches(SessionFactory sf) {
		
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("Enter BranchId:");

		int id = sc.nextInt();

		Branches branch = session.get(Branches.class, id);
		if (branch != null){//checks if the grade exists and delets it if found
			session.delete(branch);
		System.out.println("deleted successfully");
		}
		else {
			System.out.println("Bank with id " + id + "does not exist");
		}
		
		transaction.commit();
		session.close();
		
		
	}

	
	public void getBranchesdetails(SessionFactory sf) {
		session = sf.openSession();
		System.out.println("Enter Branchid:");
		int id = sc.nextInt();
		Branches branch = session.get(Branches.class, id);
		if(branch!=null) {
			System.out.println(branch);
			System.out.println("--branch deatails retrieved successfully--");
		}
		else {
			System.out.println("Bank with id " + id + "does not exist");
		}
		session.close();
	}
	
	
 public void getAllBranches(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from Branches");//create and execute the query to fetch all Brancj records
		List<Branches> resultList = query.getResultList();//execute the query and retrieve the results as a list of grade objects

		for (Branches branch : resultList)//iterate through the results and prints each grade*
			System.out.println(branch);

		session.close();
	}
	
}

