package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface TransactionsService {

	void insertTransactions(SessionFactory sf);

	void updateTransactions(SessionFactory sf);

	void deleteTransactions(SessionFactory sf);

	void getTransactionsdetails(SessionFactory sf);
	
	
}
