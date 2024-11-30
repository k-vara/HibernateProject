package com.hibernate.entity;

import java.util.ArrayList;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account_Holder {
	@Id
	 @Column(name = "acc_holId")
     private int acc_holId;
     private String acc_holName;
     private String address;
     private long Phonenum;
     
     @OneToMany(mappedBy = "accHolder", cascade = CascadeType.ALL)
     private List<AccountInfo> accounts = new ArrayList<>(); 
     
     public List<AccountInfo> getaccounts() {
	        return accounts ;
	    }

	    public void setBranches(List<AccountInfo> accounts) {
	        this.accounts = accounts;
	    }
	    public Account_Holder() {
	    	
	    }
	    
	    @OneToMany(mappedBy = "Accholder", cascade = CascadeType.ALL) 
	    private List<Loan> loan = new ArrayList<>(); 

	    public List<Loan> getloan() {
	        return loan;
	    }

	    public void setLoan(List<Loan> loan ) {
	        this.loan = loan;
	    }

		public int getAcc_holId() {
			return acc_holId;
		}

		public void setAcc_holId(int acc_holId) {
			this.acc_holId = acc_holId;
		}

		public String getAcc_holName() {
			return acc_holName;
		}

		public void setAcc_holName(String acc_holName) {
			this.acc_holName = acc_holName;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public long getPhonenum() {
			return Phonenum;
		}

		public void setPhonenum(long phonenum) {
			Phonenum = phonenum;
		}

		public List<AccountInfo> getAccounts() {
			return accounts;
		}

		public void setAccounts(List<AccountInfo> accounts) {
			this.accounts = accounts;
		}

		public List<Loan> getLoan() {
			return loan;
		}
}