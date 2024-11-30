package com.hibernate.serciceImpl;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.entity.Branches;
import com.hibernate.entity.Employee;
import com.hibernate.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	Scanner sc = new Scanner(System.in);
	Session session;
	
	public void insertEmployee(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();
	
		 Employee emp= new   Employee ();

		System.out.println("Enter values for Employee i.e empid,empname,salary");
		int  empId = sc.nextInt();
		emp.setEmployeeId( empId);
		String empname = sc.next();
		emp.setEmployeeName(empname);
		int salary=sc.nextInt();
		emp.setSalary(salary);
		
		session.persist(emp);//saves the accountinfo object to the database
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
				transaction.commit();
				break;
			case 2:
				System.out.println("Enter empId:");
				emp= session.get(Employee.class,sc.nextInt());                                                      
				System.out.println("Enter salary:");

				emp.setSalary(sc.nextInt());
				session.saveOrUpdate(emp);
				transaction.commit();
				break;
			case 3:
				System.out.println("Enter empId:");
				emp= session.get(Employee.class,sc.nextInt());                                                      
				System.out.println("Enter BranchId:");


				int Branchid = sc.nextInt();
				Branches branch = session.get(Branches.class, Branchid);
				emp.setBranch(branch);

				session.saveOrUpdate(emp);
				transaction.commit();
				break;
			case 4:	
				
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
	
	public void deleteEmployee(SessionFactory sf) {
		session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		System.out.println("enter empId:");

		int empId = sc.nextInt();

		 Employee emp = new   Employee();
		if (emp != null)//checks if the empl exists and delets it if found
			session.delete(emp);
		else
			System.out.println("Enter valid empid");
		transaction.commit();
		session.close();
		
		
		
	}

	public void getEmployeedetails(SessionFactory sf) {
		
		session = sf.openSession();

		System.out.println("enter empId:");

		int empId = sc.nextInt();

		Employee emp =session.get( Employee.class, sc.nextInt());
		System.out.println(emp );

		session.close();
		
		
	}

	
	
	
}
