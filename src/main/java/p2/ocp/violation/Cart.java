package p2.ocp.violation;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<OrderItem> items;
	private String customerEmail;

	public Cart() {
		items = new ArrayList<OrderItem>();
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void add(OrderItem orderItem) {
		items.add(orderItem);
	}

	public double totalAmount() {
		double total = 0;
		for (OrderItem orderItem : items) {
			if (orderItem.getSku().startsWith("EACH")) {
				total += orderItem.getQuantity() * 5;
			} else if (orderItem.getSku().startsWith("WEIGHT")) {
				// quantity is in grams, price is per kg
				total += (orderItem.getQuantity() * 4) / 1000;
			} else if (orderItem.getSku().startsWith("SPECIAL")) {
				// $0.40 each; 3 for a $1.00
				total += orderItem.getQuantity() * 0.4;
				int setsOfThree = orderItem.getQuantity() / 3;
				total -= setsOfThree * 0.2;
			}
			// more rules are coming!
		}
		return total;
	}
}