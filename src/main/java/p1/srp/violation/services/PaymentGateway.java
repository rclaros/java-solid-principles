package p1.srp.violation.services;

import p1.srp.violation.exceptions.AvsMismatchException;

public class PaymentGateway {
	private String cardNumber;
	private String credentials;
	private String expiresMonth;
	private String expiresYear;
	private String nameOnCard;
	private double amountToCharge;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getExpiresMonth() {
		return expiresMonth;
	}

	public void setExpiresMonth(String expiresMonth) {
		this.expiresMonth = expiresMonth;
	}

	public String getExpiresYear() {
		return expiresYear;
	}

	public void setExpiresYear(String expiresYear) {
		this.expiresYear = expiresYear;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public double getAmountToCharge() {
		return amountToCharge;
	}

	public void setAmountToCharge(double amountToCharge) {
		this.amountToCharge = amountToCharge;
	}

	public void charge() throws AvsMismatchException {
		throw new AvsMismatchException();
	}
}