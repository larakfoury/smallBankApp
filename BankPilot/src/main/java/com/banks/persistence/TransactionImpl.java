package com.banks.persistence;

import com.banks.data.DataStore;
import com.banks.entities.Transaction;
import com.banks.types.TransactionType;

public class TransactionImpl implements TransactionIF{
	
	public Transaction addTransaction(TransactionType transactionType, double amount, int accountNumber, int customerID) {
		Transaction t = new Transaction(transactionType, amount, accountNumber);
		DataStore.getInstance().addTransactionToAccount(customerID, t);
		return t;
	}

}
