package com.banks.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.banks.dao.inmemory.DataStore;
import com.banks.manager.interfaces.AccountIF;
import com.banks.model.Account;
import com.banks.model.Transaction;
import com.banks.types.AccountType;
import com.banks.types.TransactionType;

public class AccountImpl implements AccountIF {
	
	public int generateAccountNo() {		
		return DataStore.getInstance().incrementAccountNo();
	}
	
	public int getAccountNo() {
		return DataStore.getInstance().getAccountNoToBeInc();
	}
	
	public Account addAccount(double initialCredit, AccountType accountType, HashMap<String, Transaction> listTrans, int customerID) {
		Account acc = new Account(generateAccountNo(), initialCredit, accountType, listTrans, customerID);
		DataStore.getInstance().addAccount(customerID, acc);
		return acc;
	}
	
	public Account getAccount(int customerID, int accountNo) {
		return DataStore.getInstance().getAccount(String.valueOf(customerID), accountNo);
	}
	
	public double getBalance(int customerID) {
		HashMap<String, Account> hm= DataStore.getInstance().getHmAccount(String.valueOf(customerID));
		
		double balance = 0;
		
		for (Map.Entry<String, Account> entry : hm.entrySet()) {
			balance= Double.sum(balance, entry.getValue().getInitialCredit());
		}	
		
		List<Transaction> listTransOnAccount = getListTransactionsByCustomer(customerID);
		for(Transaction t: listTransOnAccount) {
			if(TransactionType.DEBIT.equals(t.getTransactionType())) {
				balance = balance - t.getAmount();
			}else if(TransactionType.CREDIT.equals(t.getTransactionType())) {
				balance = balance + t.getAmount();
			}
		}
		return balance;
	}
	
	public List<Transaction> getListTransactionsByCustomer(int customerID){
		HashMap<String, Account> hm= DataStore.getInstance().getHmAccount(String.valueOf(customerID));
		List<Transaction> transByCustomer = new ArrayList<Transaction>(); 
		HashMap<String, Transaction> hmTrans;
		
		double balance = 0;
		for (Map.Entry<String, Account> entry : hm.entrySet()) {
			Account acct = entry.getValue();
			hmTrans = DataStore.getInstance().getTransactionsbyAcct(customerID, acct.getAccountNumber());
			if(hmTrans != null && !hmTrans.isEmpty()) {
				for (Transaction value : hmTrans.values()) {
					transByCustomer.add(value);
				}
				
			}
		}
		
		return transByCustomer;
	}

}
