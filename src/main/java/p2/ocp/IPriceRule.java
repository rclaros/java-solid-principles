package p2.ocp;

public interface IPriceRule {
	boolean isMatch(OrderItem item);

	double calculatePrice(OrderItem item);
}