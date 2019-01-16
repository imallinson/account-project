package com.qa.persistence.repository;

public interface AccountRepository {
	String getAllAccounts();

	boolean createAccount(String firstName, String lastName, String accountNumber);

	boolean deleteAccount(int id);
	
	boolean updateAccount(int id, String firstName, String lastName, String accountNumber);
}
