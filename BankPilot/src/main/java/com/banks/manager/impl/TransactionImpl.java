package com.banks.manager.impl;

import com.banks.dao.Transaction;
import com.banks.data.DataStore;
import com.banks.manager.interfaces.TransactionIF;
import com.banks.types.TransactionType;

public class TransactionImpl implements TransactionIF{
	
	public Transaction addTransaction(TransactionType transactionType, double amount, int accountNumber, int customerID) {
		Transaction t = new Transaction(transactionType, amount, accountNumber);
		DataStore.getInstance().addTransactionToAccount(customerID, t);
		return t;
	}

}
