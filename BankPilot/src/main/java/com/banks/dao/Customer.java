package com.banks.dao;

import java.util.HashMap;

public class Customer {
	private int customerID;
	private String customerName;
	private HashMap<String, Account> hmAccount;
	private int birthYear;
	
	public Customer(int customerID, String customerName, HashMap<String, Account> hmAccount, int birthYear) {
		this.customerID= customerID;
		this.customerName = customerName;
		this.hmAccount = hmAccount;
		this.birthYear = birthYear;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getBirthYear() {
		return birthYear;
	}
	
	public int getCustomerID() {
		return customerID;
	}

	public HashMap<String, Account> gethmAccount() {
		return hmAccount;
	}
	
	public void setListAccount(HashMap<String, Account> hmAccount) {
		this.hmAccount = hmAccount;
	}

}