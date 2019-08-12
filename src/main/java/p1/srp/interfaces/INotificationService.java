package p1.srp.interfaces;

import p1.srp.domain.Cart;

public interface INotificationService {
	void notifyCustomerOrderCreated(Cart cart);
}