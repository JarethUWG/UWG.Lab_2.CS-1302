package edu.westga.cs1302.lab1.test.view.textgenerator;

import static org.junit.jupiter.api.Assertions.*;
import edu.westga.cs1302.lab1.view.TextGenerator;
import edu.westga.cs1302.lab1.model.*;

import org.junit.jupiter.api.Test;

class TestGetText {

	@Test
	void testWhenBillIsEmpty() {
		Bill current_bill = new Bill();
		TextGenerator text_generator = new TextGenerator(current_bill);
		String text = text_generator.getText();
		assertEquals("ITEMS\r\n" + "\r\n" + "SUBTOTAL - $0.00\r\n" + "TAX - $0.00\r\n" + "TIP - $0.00\r\n" + "TOTAL - $0.00", text);
	}

	@Test
	void testWhenBillHasOneItem() {
		Bill current_bill = new Bill();
		BillItem item1 = new BillItem("Item1", 5.99);
		current_bill.addItem(item1);
		TextGenerator text_generator = new TextGenerator(current_bill);
		String text = text_generator.getText();
		assertEquals("ITEMS\r\n" + "Item1 - 5.99\r\n" + "\r\n" + "SUBTOTAL - $5.99\r\n" + "TAX - $0.60\r\n" + "TIP - $1.20\r\n" + "TOTAL - $7.79", text);
	}
	
	@Test
	void testWhenBillHasManyItems() {
		Bill current_bill = new Bill();
		BillItem item1 = new BillItem("Item1", 5.99);
		BillItem item2 = new BillItem("Item2", 9.00);
		BillItem item3 = new BillItem("Item3", 10.01);
		current_bill.addItem(item1);
		current_bill.addItem(item2);
		current_bill.addItem(item3);
		TextGenerator text_generator = new TextGenerator(current_bill);
		String text = text_generator.getText();
		assertEquals("ITEMS\r\n" + "Item1 - 5.99\r\n" + "Item2 - 9.00\r\n" + "Item3 - 10.01\r\n" + "\r\n" + "SUBTOTAL - $25.00\r\n" + "TAX - $2.50\r\n" + "TIP - $5.00\r\n" + "TOTAL - $32.50", text);
	}
}
