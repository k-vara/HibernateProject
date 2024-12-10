package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface BankService {
	
	void insertBank(SessionFactory sf);

	void updateBank(SessionFactory sf);

	void deleteBank(SessionFactory sf);

	void getBankdetails(SessionFactory sf);
	
	void getAllBank(SessionFactory sf);
	
	
	
	
}
