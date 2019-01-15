package com.qa;

import static org.junit.Assert.*;

import org.junit.*;

public class Tests {
	Service service = new Service();
	
	@Test
	public void test() {
		service.addAccount("Ian", "Mallinson");
		assertEquals("Ian" , service.getAccount(1).getFirstName());
	}
}
