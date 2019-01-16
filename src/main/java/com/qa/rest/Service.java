package com.qa.rest;

import java.util.HashMap;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class Service {
	private JSONUtil util = new JSONUtil();
	
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
	
	public String getJSON(int accountNumber) {
		Account account = accounts.get(accountNumber);
		return util.getJSONForObject(account);
	}

	public int searchName(String firstName) {
		return (int) accounts.values().stream().filter(a -> a.getFirstName().equals(firstName)).count();		
	}
}
