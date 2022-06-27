package com.banks.manager.interfaces;

import java.util.HashMap;
import java.util.List;

import com.banks.dao.Account;
import com.banks.dao.Transaction;
import com.banks.types.AccountType;

public interface AccountIF {
	
	public Account addAccount(double initialCredit, AccountType accountType, HashMap<String, Transaction> listTrans, int customerID);
	
	public Account getAccount(int customerID, int accountNo);
	
	public double getBalance(int customerID);
	
	public List<Transaction> getListTransactionsByCustomer(int customerID);
	
	public int getAccountNo();
	
}
