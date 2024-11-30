package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.AccountInfo;
import com.hibernate.entity.Account_Holder;
import com.hibernate.entity.Bank;
import com.hibernate.entity.Branches;
import com.hibernate.entity.Employee;
import com.hibernate.entity.Loan;
import com.hibernate.entity.Transactions;
import com.hibernate.serciceImpl.AccountInfoServiceImpl;
import com.hibernate.serciceImpl.Account_HolderServiceImpl;
import com.hibernate.serciceImpl.BankServiceImpl;
import com.hibernate.serciceImpl.BranchesServiceImpl;
import com.hibernate.serciceImpl.EmployeeServiceImpl;
import com.hibernate.serciceImpl.LoanServiceImpl;
import com.hibernate.serciceImpl.TransactionsServiceImpl;
import com.hibernate.utility.ConfiguarationUtility;

public class BankApplicationMgmt {

    public static void main(String[] args) {
        SessionFactory getsFactory = ConfiguarationUtility.getsFactory();
        Session openSession = getsFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        Scanner sc = new Scanner(System.in);
        Bank bank1=new Bank();
		bank1.setBankId(1);
		bank1.setBankName("SBI");
		bank1.setAddress("India");
		openSession.persist(bank1);
		
		Branches branch1=new Branches();
		branch1.setBranchId(11);
		branch1.setBranchName("Hafeezpet");
		branch1.setManagerName("suresh");
		// Set relationship
        branch1.setBank(bank1); // Set the bank for the branch
        bank1.getBranches().add(branch1); // Add the branch to the bank's collection
		openSession.persist(branch1);

		Bank bank2=new Bank();
		bank2.setBankId(2);
		bank2.setBankName("KBS");
		bank2.setAddress("India");
		Branches branch2=new Branches();
		branch2.setBranchId(22);
		branch2.setBranchName("Konadapur");
		branch2.setManagerName("Madhavi");
		openSession.persist(branch2);
		// Set relationship
        branch2.setBank(bank2); // Set the bank for the branch
        bank2.getBranches().add(branch2); // Add the branch to the bank's collection
		openSession.persist(bank2);
		
		Account_Holder accholder=new Account_Holder();
		accholder.setAcc_holId(101);
		accholder.setAcc_holName("Devika");
		accholder.setAddress("Hyderabad");
		accholder.setPhonenum(995563257L);
		 
		//session.persist(accountHolder);
		openSession.persist(accholder);
		
		
		//creating account Info
         AccountInfo accountInfo = new AccountInfo();
         accountInfo.setAccountId(1);
         accountInfo.setAccountType("savings");
         accountInfo.setBalance(10000);
         accountInfo.setBranches(branch1); // Set the branch for AccountInfo
         accountInfo.setAccHolder(accholder); // Set the account holder

         branch1.getAccountInfo().add(accountInfo); // Add AccountInfo to branch
         accholder.getAccounts().add(accountInfo); // Add AccountInfo to account holder
         openSession.persist(accountInfo); // Persist AccountInfo

         // Creating a transaction
         Transactions trs1 = new Transactions();
         trs1.setTransactionId(111);
         trs1.setTransactiontype("Withdraw");
         trs1.setAmount(50000);
         trs1.setAccInfo(accountInfo); // Set the associated account info
         accountInfo.getTransactions().add(trs1); // Add transaction to account info
         openSession.persist(trs1); 
         
         //creating a Employee object
         Employee emp1=new Employee();
        
         emp1.setEmployeeId(01);
         emp1.setEmployeeName("Thanuja");
         emp1.setSalary(50000);
         emp1.setBranch(branch1); // Set the associated branch
         branch1.getEmp().add(emp1); // Add emp to branch
         openSession.persist(emp1); 
         
         Loan loan1=new Loan();
         loan1.setLoanId(12);
         loan1.setLoanType("Gold loan");
         loan1.setAmount(50000);
         loan1.setEmployee(emp1); // Set the employee for loan
         loan1.setAccholder(accholder);  
         emp1.getloan().add(loan1); // add loan to employee
         accholder.getloan().add(loan1);
         openSession.persist(loan1); 
         
    
		transaction.commit();
		openSession.close();
		
		}
	}
       