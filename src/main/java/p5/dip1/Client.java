package p5.dip1;

public class Client {

	public static void main(String[] args) {
		ICreditCard creditCard = new MasterCard();
		//ICreditCard creditCard = new Visa();
		Shopper shopper = new Shopper(creditCard);
		shopper.charge();
	}
}