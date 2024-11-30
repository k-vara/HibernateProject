package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface AccountInfoService {
	void insertAccountInfo(SessionFactory sf);

	void updateAccountInfo(SessionFactory sf);

	void deleteAccountInfo(SessionFactory sf);

	void getAccountInfodetails(SessionFactory sf);
}
