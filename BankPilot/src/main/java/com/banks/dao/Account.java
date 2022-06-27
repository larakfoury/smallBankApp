package com.banks.dao;

import java.util.HashMap;
import java.util.List;

import com.banks.types.AccountType;

public class Account {

	private int accountNumber;
	private double initialCredit;
	private AccountType accountType;
	private HashMap<String, Transaction> hmTrans;
	private int customerID;
	
	public Account(int accountNumber, double initialCredit, AccountType accountType, HashMap<String, Transaction> hmTrans,
			int customerID) {
		super();
		this.accountNumber = accountNumber;
		this.initialCredit = initialCredit;
		this.accountType = accountType;
		this.hmTrans = hmTrans;
		this.customerID = customerID;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getInitialCredit() {
		return initialCredit;
	}
	public void setInitialCredit(double initialCredit) {
		this.initialCredit = initialCredit;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public HashMap<String, Transaction> getHmTransMap() {
		return hmTrans;
	}
	public void setListTrans(HashMap<String, Transaction> hmTrans) {
		this.hmTrans = hmTrans;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	

}
