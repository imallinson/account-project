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
	public boolean createAccount(String firstName, String lastName, String accountNumber) {
		accounts.put(counter, new Account(firstName, lastName, accountNumber));
		counter++;
		return true;
	}

	@Override
	public boolean deleteAccount(int id) {
		if (accounts.containsKey(id)) {
			accounts.remove(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAccount(int id, String firstName, String lastName, String accountNumber) {
		if (accounts.containsKey(id)) {
			accounts.put(id, new Account(firstName, lastName, accountNumber));
			return true;
		}
		return false;
	}

}
