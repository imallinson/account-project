package com.qa.persistence.repository;

public interface AccountRepository {
	String getAllAccounts();

	String createAccount(String firstName, String lastName, String accountNumber);

	String deleteAccount(int id);
	
	String updateAccount(int id, String firstName, String lastName, String accountNumber);
}
