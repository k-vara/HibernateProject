package com.hibernate.entity;

import java.util.ArrayList;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Account_Holder {
	@Id
	//defining the accountholder attributes
	 @Column(name = "acc_holId")
     private int acc_holId;
     private String acc_holName;
     private String address;
     private long Phonenum;
  // Indicates that an Account_Holder can have multiple associated AccountInfo records.
     @OneToMany(mappedBy = "accHolder", cascade = CascadeType.ALL)
     
  // Initializes a list to store associated AccountInfo entities for this Account_Holder 
     private List<AccountInfo> accounts = new ArrayList<>(); 
     
  // Getter method for retrieving the list of AccountInfo associated with this Account_Holder.   
     public List<AccountInfo> getaccounts() {
	        return accounts ;
	    }
  // Setter method for setting the list of AccountInfo for this Account_Holder.
	    public void setBranches(List<AccountInfo> accounts) {
	        this.accounts = accounts;
	    }
	    public Account_Holder() {
	    	
	    }
	   
	 // Defines a one-to-many relationship between Account_Holder and Loan entities.
	 // Indicates that an Account_Holder can have multiple associated Loan records.   
	    @OneToMany(mappedBy = "Accholder", cascade = CascadeType.ALL) 
	 // Initializes a list to store associated Loan entities for this Account_Holder.
	    private List<Loan> loan = new ArrayList<>(); 
	 // Getter method for retrieving the list of Loan records associated with this Account_Holder.
	    public List<Loan> getloan() {
	        return loan;
	    }
	 // setter method for Setting the list of Loan records associated with this Account_Holder.
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