package p1.srp.domain;

public abstract class Order {
	protected Cart _cart;

	protected Order(Cart cart) {
		this._cart = cart;
	}

	public void checkout() {
		System.out.println("checkout");
	}
}