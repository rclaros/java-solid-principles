package p1.srp.services;

import p1.srp.domain.PaymentDetails;
import p1.srp.interfaces.IPaymentProcessor;

public class PaymentProcessor implements IPaymentProcessor {

	public void processCreditCard(PaymentDetails paymentDetails, double amount) {
		throw new UnsupportedOperationException();
	}

}