package com.hibernate.service;

import org.hibernate.SessionFactory;

import com.hibernate.utility.InsufficientBalanceException;

public interface AccountInfoService {
	void insertAccountInfo(SessionFactory sf) throws InsufficientBalanceException;

	void updateAccountInfo(SessionFactory sf);

	void deleteAccountInfo(SessionFactory sf);

	void getAccountInfodetails(SessionFactory sf);
	
	void getAllAccountInfo(SessionFactory sf);
}
