package com.qa.persistence.repository;

public interface AccountRepository {
	String getAllAccounts();

	String createAccount(String firstName, String lastName);

	String deleteAccount(Long id);
	
	String updateAccount(Long id, String firstName, String lastName);
}
