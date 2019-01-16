package com.qa.testing;

import static org.junit.Assert.*;   
import org.junit.*;

import com.qa.rest.Service;

public class Tests {
	Service service;
	
	@Before
	public void before() {
		service = new Service();
	}
	
	@Test
	public void addTest() {
		assertTrue(service.addAccount("Ian", "Mallinson"));
	}
	
	@Test
	public void getTest() {
		service.addAccount("Ian", "Mallinson");
		assertEquals("Ian" , service.getAccount(1).getFirstName());
		assertEquals("Mallinson" , service.getAccount(1).getLastName());
		assertEquals(1 , service.getAccount(1).getAccountNumber());
	}
	
	@Test
	public void jsonTest() {
		service.addAccount("Ian", "Mallinson");
		assertEquals("{\"firstName\":\"Ian\",\"lastName\":\"Mallinson\",\"accountNumber\":1}" , service.getJSON(1));
	}
	
	@Test
	public void nameSearchTest() {
		service.addAccount("Ian", "Mallinson");
		service.addAccount("Bob", "Mallinson");
		service.addAccount("Ian", "Mallinson");
		assertEquals(2, service.searchName("Ian"));
		assertEquals(1, service.searchName("Bob"));
	}
}
