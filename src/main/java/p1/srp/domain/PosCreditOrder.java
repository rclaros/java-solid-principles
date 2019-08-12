package p1.srp.domain;

import p1.srp.interfaces.IPaymentProcessor;
import p1.srp.services.PaymentProcessor;

public class PosCreditOrder extends Order {

	private PaymentDetails _paymentDetails;
	private IPaymentProcessor _paymentProcessor;

	protected PosCreditOrder(Cart cart, PaymentDetails paymentDetails) {
		super(cart);
		this._paymentDetails = paymentDetails;
		this._paymentProcessor = new PaymentProcessor();
	}

	public void checkout() {
		_paymentProcessor.processCreditCard(_paymentDetails, this._cart.getTotalAmount());
		super.checkout();
	}
}