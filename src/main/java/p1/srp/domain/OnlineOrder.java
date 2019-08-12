package p1.srp.domain;

import p1.srp.interfaces.INotificationService;
import p1.srp.interfaces.IPaymentProcessor;
import p1.srp.interfaces.IReservationService;
import p1.srp.services.NotificationService;
import p1.srp.services.PaymentProcessor;
import p1.srp.services.ReservationService;

public class OnlineOrder extends Order {
	private INotificationService _notificationService;
	private PaymentDetails _paymentDetails;
	private IPaymentProcessor _paymentProcessor;
	private IReservationService _reservationService;

	protected OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
		super(cart);
		_paymentDetails = paymentDetails;
		_paymentProcessor = new PaymentProcessor();
		_reservationService = new ReservationService();
		_notificationService = new NotificationService();
	}

	public void checkout() {
		_paymentProcessor.processCreditCard(_paymentDetails, this._cart.getTotalAmount());

		_reservationService.reserveInventory(this._cart.getItems());

		_notificationService.notifyCustomerOrderCreated(this._cart);

		super.checkout();
	}

}