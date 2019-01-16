package com.qa.business.service;

import static org.junit.Assert.*;   
import org.junit.*;

import com.qa.business.service.Service;

public class ServiceTests {
	Service service;
	
	@Before
	public void before() {
		service = new Service();
		service.addAccount("Ian", "Mallinson");
		service.addAccount("Bob", "Mallinson");
		service.addAccount("Ian", "Mallinson");
	}
	
	@Test
	public void addAccountTest() {
		assertTrue(service.addAccount("Ian", "Mallinson"));
	}
	
	@Test
	public void getAccountTest() {
		assertEquals("Ian" , service.getAccount(1).getFirstName());
		assertEquals("Mallinson" , service.getAccount(1).getLastName());
		assertEquals(1 , service.getAccount(1).getAccountNumber());
	}
	
	@Test
	public void jsonTest() {
		assertEquals("{\"firstName\":\"Ian\",\"lastName\":\"Mallinson\",\"accountNumber\":1}" , service.getJSON(1));
	}
	
	@Test
	public void nameSearchTest() {
		assertEquals(2, service.searchName("Ian"));
		assertEquals(1, service.searchName("Bob"));
		assertEquals(0, service.searchName("Alice"));
	}
}
