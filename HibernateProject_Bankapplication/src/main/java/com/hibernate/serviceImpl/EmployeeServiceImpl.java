package com.hibernate.serviceImpl;

import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.entity.Bank;
import com.hibernate.entity.Branches;
import com.hibernate.entity.Employee;
import com.hibernate.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	Scanner sc = new Scanner(System.in);
	Session session;
	
	public void insertEmployee(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		 Employee emp= new Employee ();

		System.out.println("Enter values for Employee i.e empid,empname,salary");
		int  empId = sc.nextInt();
		emp.setEmployeeId( empId);
		String empname = sc.next();
		emp.setEmployeeName(empname);
		int salary=sc.nextInt();
		emp.setSalary(salary);
		
		 System.out.println("Enter Branch ID:");
	        int branchId = sc.nextInt();
	        Branches branch = session.get(Branches.class, branchId); // Retrieve the Branch

	        if (branch == null) {
	            System.out.println("Branch not found! Cannot insert employee.");
	            return; // Exit if the branch does not exist
	        }

	        emp.setBranch(branch); // Set the branch for the Employee

		session.persist(emp);//saves the employee object to the database
		transaction.commit();
		session.close();

	}
	
	public void updateEmployee(SessionFactory sf) {
	
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Employee emp;
		try {
		while (true) {
			System.out.println("Choose option for update \n1.Update empname \n2.Update salary\n3.update BranchId\n4.Exit");

					
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter empId:");
				emp= session.get(Employee.class,sc.nextInt());                                                      
				System.out.println("Enter empname:");

				emp.setEmployeeName(sc.next());
				session.saveOrUpdate(emp);
				System.out.println("--updated empname successfully--");
				transaction.commit();
				break;
			case 2:
			    System.out.println("Enter empId:");
			    emp = session.get(Employee.class, sc.nextInt());

			    if (emp == null) {
			        System.out.println("Employee not found!");
			        break;
			    }

			    System.out.println("Enter salary:");
			    emp.setSalary(sc.nextInt());
			    
			    session.saveOrUpdate(emp); // Persist the changes
			    session.flush(); // Ensure the changes are flushed to the database
			    transaction.commit(); // Commit the transaction
			    System.out.println("--Updated employee salary successfully--");
			    break;
	                
			case 3:
			    System.out.println("Enter empId:");
			    emp = session.get(Employee.class, sc.nextInt());
			    if (emp == null) {
			        System.out.println("Employee not found!");
			        break;
			    }

			    System.out.println("Enter BranchId:");
			    int branchId = sc.nextInt();

			    // Fetch the branch entity
			    Branches branch = session.get(Branches.class, branchId);
			    if (branch == null) {
			        System.out.println("Invalid BranchId. Cannot update employee without a valid branch.");
			        break;
			    }

			    // Assign and update
			    emp.setBranch(branch);
			    session.saveOrUpdate(emp); // Persist changes
			    session.flush();           // Force Hibernate to execute SQL
			    transaction.commit();      // Commit the transaction
			    System.out.println("--Updated branch successfully--");
			    break;

			case 4:	
				
				System.out.println("exiting from update Employee");
			
				return;
				

			default:
				System.out.println("Choose the correct option");
				break;
			}
		}
	} 
    
		catch (Exception e) {
		    if (transaction != null) {
		        transaction.rollback();
		    }
		    e.printStackTrace();
		}finally {
		    
		session.close();
	}
}	
	
	public void deleteEmployee(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter empId:");

		int empId = sc.nextInt();

		 Employee emp = session.get( Employee.class, empId);
		
		 if (emp != null){//checks if the grade exists and delets it if found
				session.delete(emp);
			System.out.println("---deleted successfully----");
			}
			else {
				System.out.println("employee with id " + empId + " does not exist");
			}
		transaction.commit();
		session.close();
		
		
		
	}

	public void getEmployeedetails(SessionFactory sf) {
		
		session = sf.openSession();

		System.out.println("enter empId:");

		int empId = sc.nextInt();

		Employee emp =session.get( Employee.class, empId);
		
		if (emp != null){//checks if the grade exists and delets it if found
			System.out.println(emp );
		System.out.println("-------employee deatails retrieved successfully------");
		}
		else {
			System.out.println("employee with id " + empId + "does not exist");
		}

		session.close();
		
		
	}
	public void getAllEmployee(SessionFactory sf) {
		session = sf.openSession();

		//hql query
		Query query = session.createQuery("from Employee");//create and execute the query to fetch all employee records
		List<Employee> resultList = query.getResultList();//execute the query and retrieve the results as a list of Employee objects

		for (Employee e : resultList)//iterate through the results and prints each grade*
			System.out.println(e);

		System.out.println("-------ALL employeedeatails retrieved successfully------");
		
		session.close();
	}
	
	
}

	
	
	

