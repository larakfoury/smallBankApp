package com.banks.persistence;

import com.banks.entities.Transaction;
import com.banks.types.TransactionType;

public interface TransactionIF {
	
	public Transaction addTransaction(TransactionType transactionType, double amount, int accountNumber, int customerID);

}
