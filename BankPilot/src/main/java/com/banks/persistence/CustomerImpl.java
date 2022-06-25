package com.banks.persistence;

import java.util.HashMap;

import com.banks.data.DataStore;
import com.banks.entities.Account;
import com.banks.entities.Customer;

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
