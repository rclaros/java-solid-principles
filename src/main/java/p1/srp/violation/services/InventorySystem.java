package p1.srp.violation.services;

import p1.srp.violation.exceptions.InsufficientInventoryException;

public class InventorySystem {
	public void Reserve(String sku, int quantity) throws InsufficientInventoryException {
		throw new InsufficientInventoryException();
	}
}