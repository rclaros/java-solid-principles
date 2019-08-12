package p1.srp.interfaces;

import p1.srp.domain.OrderItem;

public interface IReservationService {
	void reserveInventory(Iterable<OrderItem> items);
}