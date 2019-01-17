package com.qa.persistence.repository;

import java.util.HashMap;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {
	private HashMap<Integer, Account> accounts = new HashMap<>();
	private int counter = 1;

	private JSONUtil util = new JSONUtil();

	@Override
	public String getAllAccounts() {
		return util.getJSONForObject(accounts);
	}

	@Override
	public String createAccount(String firstName, String lastName, String accountNumber) {
		accounts.put(counter, new Account(firstName, lastName, accountNumber));
		counter++;
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	public String deleteAccount(int id) {
		if (accounts.containsKey(id)) {
			accounts.remove(id);
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}

	@Override
	public String updateAccount(int id, String firstName, String lastName, String accountNumber) {
		if (accounts.containsKey(id)) {
			accounts.put(id, new Account(firstName, lastName, accountNumber));
			return "{\"message\": \"account has been sucessfully updated\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}

}
