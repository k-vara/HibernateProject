package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface Account_HolderService {
	void insertAccount_Holder(SessionFactory sf);

	void updateAccount_Holder(SessionFactory sf);

	void deleteAccount_Holder(SessionFactory sf);

	void getAccount_Holderdetails(SessionFactory sf);
	
}
