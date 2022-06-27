package com.banks.manager.interfaces;

import com.banks.dao.Transaction;
import com.banks.types.TransactionType;

public interface TransactionIF {
	
	public Transaction addTransaction(TransactionType transactionType, double amount, int accountNumber, int customerID);

}
