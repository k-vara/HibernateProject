package com.hibernate.main;

import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.serviceImpl.AccountInfoServiceImpl;
import com.hibernate.serviceImpl.Account_HolderServiceImpl;
import com.hibernate.serviceImpl.BankServiceImpl;
import com.hibernate.serviceImpl.BranchesServiceImpl;
import com.hibernate.serviceImpl.EmployeeServiceImpl;
import com.hibernate.serviceImpl.LoanServiceImpl;
import com.hibernate.serviceImpl.TransactionsServiceImpl;
import com.hibernate.utility.ConfiguarationUtility;
import com.hibernate.utility.InsufficientBalanceException;



public class BankApplicationMgmt {

    public static void main(String[] args)  throws InsufficientBalanceException{
    	
    	// Creates a SessionFactory instance using ConfiguarationUtility for database connection
        SessionFactory getsFactory = ConfiguarationUtility.getsFactory();

        // Opens a session from the SessionFactory to interact with the database
        Session openSession = getsFactory.openSession();

        // Begins a transaction to ensure data consistency during operations
        Transaction transaction = openSession.beginTransaction();
       
        // Scanner for user input
        Scanner sc = new Scanner(System.in);

        // Boolean to control application loop
        boolean selectchoice = true;
       
       try {
        	 while(selectchoice) { 
        		 System.out.println("-------welcome to BANK Application--------");
                 System.out.println("-----Select an option to manage entities----\n1. Bank \n2. Branch \n3. Account Holder \n4. Account Info \n5. Employee \n6. Transaction \n7. Loan \n8. Exit");
                 // Reads user's selection for service option

             
                int serviceoption = sc.nextInt();
                
                // Switch to handle different entity management operations based on user input
                switch (serviceoption) {
                    case 1:
                        manageBank(sc, getsFactory); // Manage bank operations
                        break;
                    case 2:
                        manageBranch(sc, getsFactory); // Manage branch operations
                        break;
                    case 3:
                        manageAccountHolder(sc, getsFactory); // Manage account holder operations
                        break;
                    case 4:
                        manageAccountInfo(sc, getsFactory); // Manage account information operations
                        break;
                    case 5:
                        manageEmployee(sc, getsFactory); // Manage employee operations
                        break;
                    case 6:
                        manageTransaction(sc, getsFactory); // Manage transaction operations
                        break;
                    case 7:
                        manageLoan(sc, getsFactory); // Manage loan operations
                        break;
                    case 8:
                       // selectchoice = false; // Exit the loop and end the application
                        System.out.println("Exiting the Bank application.");
                        return;
                        
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
       finally {
    	   
       }
    }
    
        
    
//------method for manage bank-------
    private static void manageBank(Scanner sc, SessionFactory getsFactory) {
        BankServiceImpl bankService = new BankServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Bank \n2. Update Bank \n3. Delete Bank \n4. Get Bank Details \n5.GetAllBank \n6.Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    bankService.insertBank(getsFactory);
                    break;
                case 2:
                    bankService.updateBank(getsFactory);
                    break;
                case 3:
                    bankService.deleteBank(getsFactory);
                    break;
                case 4:
                    bankService.getBankdetails(getsFactory);
                    break;
                case 5:
                    bankService.getAllBank(getsFactory);
                    break;   
                    
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
  //------method for manage branch---
    private static void manageBranch(Scanner sc, SessionFactory getsFactory) {
        BranchesServiceImpl branchService = new BranchesServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Branch \n2. Update Branch \n3. Delete Branch \n4. Get BranchesDetails \n5.GetAllBranches \n6.Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    branchService.insertBranches(getsFactory);
                    break;
                case 2:
                    branchService.updateBranches(getsFactory);
                    break;
                case 3:
                    branchService.deleteBranches(getsFactory);
                    break;
                case 4:
                    branchService.getBranchesdetails(getsFactory);
                    break;
                case 5:
                    branchService.getAllBranches(getsFactory);
                    break;    
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  //------method for manageaccountHolder---
    private static void manageAccountHolder(Scanner sc, SessionFactory getsFactory) {
        Account_HolderServiceImpl acchoderService = new Account_HolderServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Account Holder \n2. Update Account Holder \n3. Delete Account_Holder \n4. Get Account_HolderDetails \n5.GetAll Account_Holder \n6.Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    acchoderService.insertAccount_Holder(getsFactory);
                    break;
                case 2:
                    acchoderService.updateAccount_Holder(getsFactory);
                    break;
                case 3:
                    acchoderService.deleteAccount_Holder(getsFactory);
                    break;
                case 4:
                    acchoderService.getAccount_Holderdetails(getsFactory);
                    break;
                case 5:
                acchoderService.getAllAccount_Holder(getsFactory);
                    break;
                	
                case 6:	
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  //------method for manageaccountInfo---
    private static void manageAccountInfo(Scanner sc, SessionFactory getsFactory) throws InsufficientBalanceException{
        AccountInfoServiceImpl accountService = new AccountInfoServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Account Info \n2. Update Account Info \n3. Delete Account Info \n4. Get Account Info Details \n5. GetAllAccountInfo \n6.Exit");
            int option = sc.nextInt();
     
            switch (option) {
                case 1:
                    accountService.insertAccountInfo(getsFactory) ;

                    break;
                case 2:
                    accountService.updateAccountInfo(getsFactory);
                    break;
                case 3:
                    accountService.deleteAccountInfo(getsFactory);
                    break;
                case 4:
                    accountService.getAccountInfodetails(getsFactory);
                    break;
                case 5:
                	accountService.getAllAccountInfo(getsFactory);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
       
    
      }
        }
    
    

  //------method for manage employee---
    private static void manageEmployee(Scanner sc, SessionFactory getsFactory) {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Employee \n2. Update Employee \n3. Delete Employee \n4. Get Employee Details \n5.GetAll Employee \n6. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    employeeService.insertEmployee(getsFactory);
                    break;
                case 2:
                    employeeService.updateEmployee(getsFactory);
                    break;
                case 3:
                    employeeService.deleteEmployee(getsFactory);
                    break;
                case 4:
                    employeeService.getEmployeedetails(getsFactory);
                    break;
                case 5:
                    employeeService.getAllEmployee(getsFactory);
                    break;    
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    //------Method for transaction---
    private static void manageTransaction(Scanner sc, SessionFactory getsFactory) {
        TransactionsServiceImpl transactionService = new TransactionsServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Transaction \n2. Update Transaction \n3. Delete Transaction \n4.Get TransactionDetails \n5. GetAllTransaction \n6.Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    transactionService.insertTransactions(getsFactory);
                    break;
                case 2:
                    transactionService.updateTransactions(getsFactory);
                    break;
                case 3:
                    transactionService.deleteTransactions(getsFactory);
                    break;
                case 4:
                    transactionService.getTransactionsdetails(getsFactory);
                    break;
                case 5:
                    transactionService.getAllTransactions(getsFactory);
                    break;    
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
  //------method for manageloan---
    private static void manageLoan(Scanner sc, SessionFactory getsFactory)  {
        LoanServiceImpl loanService = new LoanServiceImpl();
        while (true) {
            System.out.println("---Select option--- \n1. Insert Loan \n2. Update Loan \n3. Delete Loan \n4.Get Loan Details \n5.GetAll Loan \n6.Exit");
            int option = sc.nextInt();

            switch (option) {
                
                case 1:
				  loanService.insertLoan(getsFactory);
                    break;
                case 2:
                    loanService.updateLoan(getsFactory);
                    break;
                case 3:
                    loanService.deleteLoan(getsFactory);
                    break;
                case 4:
                    loanService.getLoandetails(getsFactory);
                    break;
                case 5:
                     loanService.getAllLoan(getsFactory);
                      break;   
                    
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}

     


