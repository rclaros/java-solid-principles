package p5.dip1;

public class Shopper {
	private ICreditCard creditCard;

	public Shopper(ICreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public void charge() {
		String chargeMessage = creditCard.charge();
		System.out.println(chargeMessage);
	}
}