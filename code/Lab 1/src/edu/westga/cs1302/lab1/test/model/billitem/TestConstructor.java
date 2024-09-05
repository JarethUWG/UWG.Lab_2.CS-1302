package edu.westga.cs1302.lab1.test.model.billitem;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.lab1.model.*;

import org.junit.jupiter.api.Test;

class TestConstructor {

	@Test
	void testWhenNormal() {
		BillItem testItem = new BillItem("Thing", 9.99);
		assertEquals("Thing", testItem.getName());
		assertEquals(9.99, testItem.getAmount());
	}
	
	@Test
	void testWhenNameNull() {
		assertThrows(IllegalArgumentException.class, () ->{
			BillItem testItem = new BillItem(null, 9.99); //"unused local variable" used in test
		});
	}
	
	@Test
	void testWhenAmountLessThanZero() {
		assertThrows(IllegalArgumentException.class, () ->{
			BillItem testItem = new BillItem("Thing", -0.01); //"unused local variable" used in test
		});
	}
	
	@Test
	void testWhenAmountZero() {
		assertThrows(IllegalArgumentException.class, () ->{
			BillItem testItem = new BillItem("Thing", 0.0); //"unused local variable" used in test
		});
	}
	
	@Test
	void testWhenAmountMoreThanZero() {
		BillItem testItem = new BillItem("Thing", 0.01);
		assertEquals("Thing", testItem.getName());
		assertEquals(0.01, testItem.getAmount());
	}
	

}
