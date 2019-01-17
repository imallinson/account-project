package com.qa.persistence.repository;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.*;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.AccountMap;

public class MapTests {
	AccountMapRepository accounts;
	Account account1;
	Account account2;
	
	@Before
	public void before() {
		accounts = new AccountMapRepository();
		AccountMap.getInstance().setAccounts(new HashMap<>());
		account1 = new Account("Ian", "Mallinson", "1");
		account2 = new Account("Bob", "Mallinson", "2");
	}
	
	@Test
	public void addAccountTest() {
		assertEquals("{\"message\": \"account has been sucessfully added\"}", account1);
	}
	
	@Test
	public void getAccountsTest() {
		accounts.createAccount(account1);
		assertEquals("{\"1\":{\"firstName\":\"Ian\",\"lastName\":\"Mallinson\",\"accountNumber\":\"1\"}}", accounts.getAllAccounts());
	}
	
	@Test
	public void deleteAccountTest() {
		accounts.createAccount(account1);
		assertEquals("{\"message\": \"account has been sucessfully deleted\"}", accounts.deleteAccount("1"));
		assertEquals("{}" ,accounts.getAllAccounts());
	}
	
	@Test
	public void deleteAccountNotExistingTest() {
		assertEquals("{\"message\": \"account does not exist\"}", accounts.deleteAccount("1"));
	}
	
	@Test
	public void updateAccountTest() {
		accounts.createAccount(account1);
		assertEquals("{\"message\": \"account has been sucessfully updated\"}", accounts.updateAccount(account2));
		assertEquals("{\"2\":{\"firstName\":\"Bob\",\"lastName\":\"Mallinson\",\"accountNumber\":\"2\"}}", accounts.getAllAccounts());
	}
	
	@Test
	public void updateAccountNotExistingTest() {
		assertEquals("{\"message\": \"account does not exist\"}", accounts.updateAccount(account2));
	}
}
