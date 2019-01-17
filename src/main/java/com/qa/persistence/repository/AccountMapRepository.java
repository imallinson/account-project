package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.AccountMap;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
public class AccountMapRepository implements AccountRepository {
	private JSONUtil util = new JSONUtil();

	@Override
	public String getAllAccounts() {
		return util.getJSONForObject(AccountMap.getInstance().getAccounts());
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String firstName, String lastName, String accountNumber) {
		AccountMap.getInstance().getAccounts().put(accountNumber, new Account(firstName, lastName, accountNumber));
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(String accountNumber) {
		if (AccountMap.getInstance().getAccounts().containsKey(accountNumber)) {
			AccountMap.getInstance().getAccounts().remove(accountNumber);
			return "{\"message\": \"account has been sucessfully deleted\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(String firstName, String lastName, String accountNumber) {
		if (AccountMap.getInstance().getAccounts().containsKey(accountNumber)) {
			AccountMap.getInstance().getAccounts().remove(accountNumber);
			AccountMap.getInstance().getAccounts().put(accountNumber, new Account(firstName, lastName, accountNumber));
			return "{\"message\": \"account has been sucessfully updated\"}";
		}
		return "{\"message\": \"account does not exist\"}";
	}
}
