package p1.srp.violation.exceptions;

@SuppressWarnings("serial")
public class OrderException extends Exception {

	public OrderException(String message, Exception innerException) {
		super(message, innerException);
	}
}