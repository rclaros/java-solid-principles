package p2.ocp;

public class Buy4GetOneFree implements IPriceRule {

	public boolean isMatch(OrderItem item) {
		return item.getSku().startsWith("B4GO");
	}

	public double calculatePrice(OrderItem item) {
		double total = 0;
		total += item.getQuantity() * 1;
		int setsOfFive = item.getQuantity() / 5;
		total -= setsOfFive * 1;
		return total;
	}
}