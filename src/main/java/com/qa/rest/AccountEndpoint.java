package com.qa.rest;

import javax.inject.Inject;

import com.qa.business.service.AccountService;

public class AccountEndpoint {
	@Inject
	private AccountService service;
	
	public String getAllAccounts() {
		return null;
	}

	public String createAccount() {
		return null;
	}

	public String deleteAccount() {
		return null;
	}

	public String updateAccount() {
		return null;
	}
	
	public void setService(AccountService service) {
		this.service = service;
	}
}
