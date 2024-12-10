package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface LoanService {

	void insertLoan(SessionFactory sf);

	void updateLoan(SessionFactory sf);

	void deleteLoan(SessionFactory sf);

	void getLoandetails(SessionFactory sf);
	
	void getAllLoan(SessionFactory sf);
	
}
