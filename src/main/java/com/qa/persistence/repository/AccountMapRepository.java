package com.qa.persistence.repository;

import java.util.HashMap;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.AccountMap;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {
	private JSONUtil util = new JSONUtil();

	@Override
	public String getAllAccounts() {
		return util.getJSONForObject(AccountMap.getInstance().getAccounts());
	}

	@Override
	public String createAccount(String firstName, String lastName, String accountNumber) {
		AccountMap.getInstance().getAccounts().put(accountNumber, new Account(firstName, lastName, accountNumber));
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	public String deleteAccount(String accountNumber) {
		if (AccountMap.getInstance().getAccounts().containsKey(accountNumber)) {
			AccountMap.getInstance().getAccounts().remove(accountNumber);
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}

	@Override
	public String updateAccount(String firstName, String lastName, String accountNumber) {
		if (AccountMap.getInstance().getAccounts().containsKey(accountNumber)) {
			AccountMap.getInstance().getAccounts().remove(accountNumber);
			AccountMap.getInstance().getAccounts().put(accountNumber, new Account(firstName, lastName, accountNumber));
			return "{\"message\": \"account has been sucessfully updated\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}
}
