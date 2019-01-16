package com.qa.persistence.repository;

import static org.junit.Assert.*;

import org.junit.*;

public class MapTests {
	AccountMapRepository accounts;
	
	@Before
	public void before() {
		accounts = new AccountMapRepository();
	}
	
	@Test
	public void addAccountTest() {
		assertTrue(accounts.createAccount("Ian", "Mallinson", "1"));
	}
	
	@Test
	public void getAccountsTest() {
		accounts.createAccount("Ian", "Mallinson", "1");
		assertEquals("{\"1\":{\"firstName\":\"Ian\",\"lastName\":\"Mallinson\",\"accountNumber\":\"1\"}}", accounts.getAllAccounts());
	}
	
	@Test
	public void deleteAccountTest() {
		accounts.createAccount("Ian", "Mallinson", "1");
		assertTrue(accounts.deleteAccount(1));
		assertEquals("{}" ,accounts.getAllAccounts());
	}
	
	@Test
	public void updateAccountTest() {
		accounts.createAccount("Ian", "Mallinson", "1");
		assertTrue(accounts.updateAccount(1, "Bob", "Mallinson", "1"));
		assertEquals("{\"1\":{\"firstName\":\"Bob\",\"lastName\":\"Mallinson\",\"accountNumber\":\"1\"}}", accounts.getAllAccounts());
	}
}
