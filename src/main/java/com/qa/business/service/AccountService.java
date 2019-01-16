package com.qa.business.service;

public interface AccountService {

	public String getAllAccounts();

	public String addAccount(String account);

	public String deleteAccount(Long id);
	
	public String updateAccount(Long id, String firstName, String lastName);

}
