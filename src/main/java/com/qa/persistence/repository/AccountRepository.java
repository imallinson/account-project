package com.qa.persistence.repository;

import com.qa.persistence.domain.Account;

public interface AccountRepository {
	String getAllAccounts();

	String createAccount(Account account);

	String deleteAccount(String accountNumber);
	
	String updateAccount(Account account);
}
