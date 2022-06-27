package com.banks.data;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.banks.dao.Account;
import com.banks.dao.Customer;
import com.banks.dao.Transaction;
import com.banks.types.AccountType;
import com.banks.types.TransactionType;

/**
 * Example DataStore class that provides access to user data.
 * Pretend this class accesses a database.
 */
public class DataStore {

	//Map of names to Person instances.
	private static Map<String, Customer> customerMap = new HashMap<>();
	
	private static int accountNoToBeInc = 300;
	
	private static int transIdToBeInc = 4;

	//this class is a singleton and should not be instantiated directly!
	private static DataStore instance;
	public static DataStore getInstance(){
		if (instance == null) {
			instance = new DataStore();
			return instance;
		}
		return instance;
	}

	//private constructor so people know to use the getInstance() function instead
	private DataStore(){
		//dummy data
		
		HashMap<String, Transaction> hmTransAcct1 = new HashMap<String, Transaction>();
		hmTransAcct1.put("1", new Transaction(TransactionType.CREDIT, Double.valueOf("10000"), 100));
		hmTransAcct1.put("2", new Transaction(TransactionType.CREDIT, Double.valueOf("15000"), 100));
		
		HashMap<String, Transaction> hmTransAcct2 = new HashMap<String, Transaction>();
		hmTransAcct2.put("3", new Transaction(TransactionType.CREDIT, Double.valueOf("10000"), 200));
		
		
		HashMap<String, Account> hmAccount1 = new HashMap<String, Account>();
		Account acc1 = new Account(100, 1000, AccountType.CURRENT, hmTransAcct1, 1);
		hmAccount1.put("100", acc1);
		
		HashMap<String, Account> hmAccount2 = new HashMap<String, Account>();
		Account acc2 = new Account(200, 2000, AccountType.SAVINGS, hmTransAcct2, 2);
		hmAccount2.put("200", acc2);
		
		HashMap<String, Account> hmAccount3 = new HashMap<String, Account>();
		Account acc3 = new Account(300, 0, AccountType.CURRENT, null, 3);
		hmAccount3.put("300", acc3);
		
		customerMap.put("1", new Customer(1, "Ada", hmAccount1, 1815));
		customerMap.put("2", new Customer(2, "Kevin", hmAccount2, 1986));
		customerMap.put("3", new Customer(3, "Stanley", hmAccount3, 2007));
	}

	public Customer getPerson(String name) {
		return customerMap.get(name);
	}
	
	public void addAccount(int customerID, Account acc) {
		customerMap.get(String.valueOf(customerID)).gethmAccount().put(String.valueOf(getAccountNoToBeInc()), acc);
	}
	
	public void addTransactionToAccount(int customerID, Transaction t) {
		HashMap<String, Transaction>  hm = customerMap.get(String.valueOf(customerID)).gethmAccount().get(String.valueOf(getAccountNoToBeInc())).getHmTransMap();
		if(hm == null) {
			hm = new HashMap<String, Transaction>();
		}
		hm.put(String.valueOf(getTransIdToBeInc()), t);
		customerMap.get(String.valueOf(customerID)).gethmAccount().get(String.valueOf(getAccountNoToBeInc())).setListTrans(hm);
	}

	public void putPerson(Customer person) {
		customerMap.put(person.getCustomerName(), person);
	}
	
	public HashMap<String, Account> getHmAccount(String customerID) {
		
		return customerMap.get(customerID).gethmAccount();
	}
	
	public Account getAccount(String customerID, int accountNo) {
		
		return customerMap.get(customerID).gethmAccount().get(String.valueOf(accountNo));
	}
	
	public HashMap<String, Transaction> getTransactionsbyAcct(int customerID, int accountNo){
		return DataStore.getInstance().getAccount(String.valueOf(customerID), accountNo).getHmTransMap();
	}

	public Customer getCustomer(int customerID) {
		// TODO Auto-generated method stub
		return customerMap.get(String.valueOf(customerID));
	}
	
	public Customer getCustomer(String customerName) {

		//if(customerMap.containsValue(customerName)) {
			for (Map.Entry<String, Customer> entry : customerMap.entrySet()) {
	              if (entry.getValue().getCustomerName().equalsIgnoreCase(customerName)) {
	            	  return entry.getValue();
	              }
			}
			
		//}
		
		return null;
	}
	public int incrementAccountNo() {
		accountNoToBeInc = accountNoToBeInc + 100;
		return accountNoToBeInc;
	}
	
	public int getAccountNoToBeInc() {
		return accountNoToBeInc;
	}
	
	public int incrementTransId() {
		transIdToBeInc = transIdToBeInc + 1;
		return transIdToBeInc;
	}
	
	public int getTransIdToBeInc() {
		return transIdToBeInc;
	}
}