package p2.ocp;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<OrderItem> items;
	private IPricingCalculator pricingCalculator;

	public Cart() {
		this(new PricingCalculator());
	}

	public Cart(IPricingCalculator pricingCalculator) {
		this.pricingCalculator = pricingCalculator;
		this.items = new ArrayList<OrderItem>();
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void add(OrderItem orderItem) {
		items.add(orderItem);
	}

	public double totalAmount() {
		double total = 0;
		for (OrderItem orderItem : items) {
			total += pricingCalculator.calculatePrice(orderItem);
		}
		return total;
	}
}