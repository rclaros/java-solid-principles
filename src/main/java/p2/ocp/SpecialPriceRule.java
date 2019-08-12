package p2.ocp;

public class SpecialPriceRule implements IPriceRule {
	public boolean isMatch(OrderItem item) {
		return item.getSku().startsWith("SPECIAL");
	}

	public double calculatePrice(OrderItem item) {
		double total = 0;
		// $0.40 each; 3 for a $1.00
		total += item.getQuantity() * 0.4;
		int setsOfThree = item.getQuantity() / 3;
		total -= setsOfThree * 0.2;
		return total;
	}
}