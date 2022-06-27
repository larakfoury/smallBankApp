package com.banks.manager.impl;

import com.banks.dao.inmemory.DataStore;
import com.banks.manager.interfaces.TransactionIF;
import com.banks.model.Transaction;
import com.banks.types.TransactionType;

public class TransactionImpl implements TransactionIF{
	
	public Transaction addTransaction(TransactionType transactionType, double amount, int accountNumber, int customerID) {
		Transaction t = new Transaction(transactionType, amount, accountNumber);
		DataStore.getInstance().addTransactionToAccount(customerID, t);
		return t;
	}

}
