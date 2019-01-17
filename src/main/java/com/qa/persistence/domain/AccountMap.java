package com.qa.persistence.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountMap {
	private static final AccountMap INSTANCE = new AccountMap();
	private Map<String, Account> accounts = new HashMap<>();


	private AccountMap() {
		
	}

	public static AccountMap getInstance() {
		return INSTANCE;
	}

	public Map<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
	}

}
