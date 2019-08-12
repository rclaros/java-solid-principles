package p1.srp.interfaces;

import p1.srp.domain.PaymentDetails;

public interface IPaymentProcessor {
	void processCreditCard(PaymentDetails paymentDetails, double amount);
}