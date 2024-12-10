package com.hibernate.service;

import org.hibernate.SessionFactory;

public interface BranchesService {
	void insertBranches(SessionFactory sf);

	void updateBranches(SessionFactory sf);
	

	void deleteBranches(SessionFactory sf);

	void getBranchesdetails(SessionFactory sf);
	
	void getAllBranches(SessionFactory sf);

	
}
