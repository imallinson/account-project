package com.qa.persistence.repository;

public interface AccountRepository {
	String getAllAccounts();

	String createAccount(String firstName, String lastName, String accountNumber);

	String deleteAccount(String accountNumber);
	
	String updateAccount(String firstName, String lastName, String accountNumber);
}
