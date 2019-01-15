package com.qa;

import static org.junit.Assert.*;

import org.junit.*;

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
	}
}
