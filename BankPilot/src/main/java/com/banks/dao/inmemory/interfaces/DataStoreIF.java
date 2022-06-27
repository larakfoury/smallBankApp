package com.banks.dao.inmemory.interfaces;

import java.util.HashMap;

import com.banks.model.Account;
import com.banks.model.Customer;
import com.banks.model.Transaction;

public interface DataStoreIF {

	public Customer getPerson(String name);
	
	public void addAccount(int customerID, Account acc);
	
	public void addTransactionToAccount(int customerID, Transaction t);

	public void putPerson(Customer person) ;
	
	public HashMap<String, Account> getHmAccount(String customerID);
	
	public Account getAccount(String customerID, int accountNo) ;
	
	public HashMap<String, Transaction> getTransactionsbyAcct(int customerID, int accountNo);

	public Customer getCustomer(int customerID);
	
	public Customer getCustomer(String customerName);
	
	public int incrementAccountNo();
	
	public int getAccountNoToBeInc();
	
	public int incrementTransId();
	
	public int getTransIdToBeInc();
}
