package com.banks.manager.interfaces;

import java.util.HashMap;

import com.banks.model.Account;
import com.banks.model.Customer;

public interface CustomerIF {
	public Customer addCustomer(int customerID, String customerName, HashMap<String, Account> hmAccount, int birthYear);
	
	public Customer getCustomer(int customerID);
	
	public Customer getCustomer(String customerName);
}
