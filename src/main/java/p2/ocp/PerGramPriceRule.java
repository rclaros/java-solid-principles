package p2.ocp;

public class PerGramPriceRule implements IPriceRule {
	public boolean isMatch(OrderItem item) {
		return item.getSku().startsWith("WEIGHT");
	}

	public double calculatePrice(OrderItem item) {
		return (item.getQuantity() * 4) / 1000;
	}
}