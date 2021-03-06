package com.banks.manager.impl;

import java.util.HashMap;

import com.banks.dao.inmemory.DataStore;
import com.banks.manager.interfaces.CustomerIF;
import com.banks.model.Account;
import com.banks.model.Customer;

public class CustomerImpl implements CustomerIF{
	public Customer addCustomer(int customerID, String customerName, HashMap<String, Account> hmAccount, int birthYear) {
		return new Customer(customerID, customerName, hmAccount, birthYear);
	}
	
	public Customer getCustomer(int customerID) {
		return DataStore.getInstance().getCustomer(String.valueOf(customerID));
	}
	
	public Customer getCustomer(String customerName) {
		
		return DataStore.getInstance().getCustomer(customerName);
	}
}
