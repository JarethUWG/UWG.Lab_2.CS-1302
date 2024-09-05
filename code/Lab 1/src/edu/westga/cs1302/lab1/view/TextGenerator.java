package edu.westga.cs1302.lab1.view;

import java.util.ArrayList;

import edu.westga.cs1302.lab1.model.Bill;
import edu.westga.cs1302.lab1.model.BillItem;

/** Displays information about a bill.
 * 
 * @author Jareth Batty
 * @version Fall 2024
 */
public class TextGenerator {
	private static final double TIP_MULTIPLIER = 0.2;
	private static final double TAX_MULTIPLIER = 0.1;
	private ArrayList<BillItem> items;
	
	/** Create a TextGenerator that is based on the provided bill
	 * 
	 * @precondition none
	 * @postcondition this.items == bill.getItems();
	 * 
	 * @param bill the bill to generate text based on.
	 */
	public TextGenerator(Bill bill) {
		this.items = bill.getItems();
	}
	
	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public String getText() {
		String text = "ITEMS" + System.lineSeparator();
		double subTotal = 0.0;
		for (BillItem item : this.items) {
			text += item.getName() + " - " + String.format("%.2f", item.getAmount()) + System.lineSeparator();
			subTotal += item.getAmount();
		}
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + String.format("%.2f", subTotal) + System.lineSeparator();
		double tax = subTotal * TAX_MULTIPLIER;
		double tip = subTotal * TIP_MULTIPLIER;
		text += "TAX - $" + String.format("%.2f", tax) + System.lineSeparator();
		text += "TIP - $" + String.format("%.2f", tip) + System.lineSeparator();
		text += "TOTAL - $" + String.format("%.2f", (subTotal + tip + tax));
		
		return text;
	}
}
