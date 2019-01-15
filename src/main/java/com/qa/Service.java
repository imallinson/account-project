package com.qa;

import java.util.HashMap;

public class Service {
	private HashMap<Integer, Account> accounts = new HashMap<>();
	private int counter = 1;
	
	public boolean addAccount(String firstName, String lastName) {
		accounts.put(counter, new Account(firstName, lastName, counter));
		counter++;
		return true;
	}
	
	public Account getAccount(int accountNumber) {
		return accounts.get(accountNumber);
	}
}
