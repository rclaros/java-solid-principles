package p1.srp.domain;

public class Cart {
	private double totalAmount;
	private Iterable<OrderItem> items;
	private String customerEmail;

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Iterable<OrderItem> getItems() {
		return items;
	}

	public void setItems(Iterable<OrderItem> items) {
		this.items = items;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
}