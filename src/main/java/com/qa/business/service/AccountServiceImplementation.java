package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImplementation implements AccountService {
	@Inject
	AccountRepository repo;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(Account account) {
		if (account.getAccountNumber() != "9999") {
			return repo.createAccount(account);
		}
		return "{\"message\": \"account is blocked\"}";
	}

	@Override
	public String deleteAccount(String accountNumber) {
		return repo.deleteAccount(accountNumber);
	}

	@Override
	public String updateAccount(Account account) {
		return repo.updateAccount(account);
	}

}
