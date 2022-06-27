package com.banks.model;

import com.banks.types.TransactionType;

public class Transaction {

	private TransactionType transactionType;
	private double amount;
	private int accountNumber;

	public Transaction(TransactionType transactionType, double amount, int accountNumber) {
		super();
		this.transactionType = transactionType;
		this.amount = amount;
		this.accountNumber = accountNumber;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


}
