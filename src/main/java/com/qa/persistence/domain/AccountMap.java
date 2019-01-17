package com.qa.persistence.domain;

import java.util.HashMap;

public class AccountMap {
	private static final AccountMap INSTANCE = new AccountMap();
	private HashMap<String, Account> accounts = new HashMap<>();


	private AccountMap() {
		
	}

	public static AccountMap getInstance() {
		return INSTANCE;
	}

	public HashMap<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashMap<String, Account> accounts) {
		this.accounts = accounts;
	}

}
