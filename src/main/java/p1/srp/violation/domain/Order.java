package p1.srp.violation.domain;

import java.util.Properties;

import common.Logger;
import p1.srp.violation.exceptions.AvsMismatchException;
import p1.srp.violation.exceptions.InsufficientInventoryException;
import p1.srp.violation.exceptions.OrderException;
import p1.srp.violation.services.InventorySystem;
import p1.srp.violation.services.PaymentGateway;

import javax.mail.*;
import javax.mail.internet.*;

public class Order {

	public void checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer)
			throws OrderException, AddressException, MessagingException {
		if (paymentDetails.getPaymentMethod() == PaymentMethod.CreditCard) {
			chargeCard(paymentDetails, cart);
		}

		reserveInventory(cart);

		if (notifyCustomer) {
			notifyCustomer(cart);
		}
	}

	public void notifyCustomer(Cart cart) throws AddressException, MessagingException {
		String customerEmail = cart.getCustomerEmail();
		if (!customerEmail.trim().isEmpty()) {
			Properties properties = new Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", "localhost");
			Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("username", "password");
				}
			});
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("orders@unmsm.edu.pe"));

			InternetAddress[] internetAddressArray = null;
			try {
				internetAddressArray = InternetAddress.parse(customerEmail);
				message.setRecipients(Message.RecipientType.TO, internetAddressArray);
				message.setSubject("Your order!");
				message.setContent("Your order details: \n " + cart.toString(), "text/html");
				Transport.send(message);
			} catch (Exception ex) {
				Logger.Error("Problem sending notification email", ex);
			}
		}
	}

	public void reserveInventory(Cart cart) throws OrderException {
		for (OrderItem item : cart.getItems()) {
			try {
				InventorySystem inventorySystem = new InventorySystem();
				inventorySystem.Reserve(item.getSku(), item.getQuantity());

			} catch (InsufficientInventoryException ex) {
				throw new OrderException("Insufficient inventory for item " + item.getSku(), ex);
			} catch (Exception ex) {
				throw new OrderException("Problem reserving inventory", ex);
			}
		}
	}

	public void chargeCard(PaymentDetails paymentDetails, Cart cart) throws OrderException {
		PaymentGateway paymentGateway = new PaymentGateway();
		try {
			paymentGateway.setCredentials("account credentials");
			paymentGateway.setCardNumber(paymentDetails.getCreditCardNumber());
			paymentGateway.setExpiresMonth(paymentDetails.getExpiresMonth());
			paymentGateway.setExpiresYear(paymentDetails.getExpiresYear());
			paymentGateway.setNameOnCard(paymentDetails.getCardholderName());
			paymentGateway.setAmountToCharge(cart.getTotalAmount());

			paymentGateway.charge();
		} catch (AvsMismatchException ex) {
			throw new OrderException("The card gateway rejected the card based on the address provided.", ex);
		} catch (Exception ex) {
			throw new OrderException("There was a problem with your card.", ex);
		}
	}
}