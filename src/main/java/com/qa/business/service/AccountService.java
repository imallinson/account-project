package com.qa.business.service;

import com.qa.persistence.domain.Account;

public interface AccountService {

	public String getAllAccounts();

	public String createAccount(Account account);

	public String deleteAccount(String accountNumber);
	
	public String updateAccount(Account account);

}
