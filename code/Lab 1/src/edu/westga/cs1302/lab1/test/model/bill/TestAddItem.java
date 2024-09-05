package edu.westga.cs1302.lab1.test.model.bill;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.lab1.model.*;

import org.junit.jupiter.api.Test;

class TestAddItem {

	@Test
	void testWhenItemNull() {
		Bill testBill = new Bill();
		assertThrows(IllegalArgumentException.class, () ->{
			testBill.addItem(null);
		});
	}
	
	@Test
	void testWhenItemNormal() {
		Bill testBill = new Bill();
		BillItem testItem = new BillItem("Thing", 9.99);
		testBill.addItem(testItem);
		assertEquals("Thing", testBill.getItems().get(0).getName());
		assertEquals(9.99, testBill.getItems().get(0).getAmount());
	}
	
	@Test
	void testWhenMultipleItems() {
		Bill testBill = new Bill();
		BillItem testItem1 = new BillItem("Thing1", 9.99);
		BillItem testItem2 = new BillItem("Thing2", 19.99);
		BillItem testItem3 = new BillItem("Thing3", 5.50);
		testBill.addItem(testItem1);
		testBill.addItem(testItem2);
		testBill.addItem(testItem3);
		assertEquals("Thing1", testBill.getItems().get(0).getName());
		assertEquals(9.99, testBill.getItems().get(0).getAmount());
		assertEquals("Thing2", testBill.getItems().get(1).getName());
		assertEquals(19.99, testBill.getItems().get(1).getAmount());
		assertEquals("Thing3", testBill.getItems().get(2).getName());
		assertEquals(5.50, testBill.getItems().get(2).getAmount());
	}

}

