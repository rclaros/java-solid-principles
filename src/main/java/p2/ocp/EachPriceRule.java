package p2.ocp;

public class EachPriceRule implements IPriceRule {

	public boolean isMatch(OrderItem item) {
		return item.getSku().startsWith("EACH");
	}

	public double calculatePrice(OrderItem item) {
		return item.getQuantity() * 5;
	}
}