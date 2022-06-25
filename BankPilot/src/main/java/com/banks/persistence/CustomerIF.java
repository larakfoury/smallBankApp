package com.banks.persistence;

import java.util.HashMap;

import com.banks.entities.Account;
import com.banks.entities.Customer;

public interface CustomerIF {
	public Customer addCustomer(int customerID, String customerName, HashMap<String, Account> hmAccount, int birthYear);
	
	public Customer getCustomer(int customerID);
	
	public Customer getCustomer(String customerName);
}
