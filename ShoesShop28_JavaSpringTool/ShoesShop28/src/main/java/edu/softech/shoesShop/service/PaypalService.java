package edu.softech.shoesShop.service;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import edu.softech.shoesShop.config.PaypalPaymentIntent;
import edu.softech.shoesShop.config.PaypalPaymentMethod;

public interface PaypalService {

	Payment executePayment(String paymentId, String payerId) throws PayPalRESTException;

	Payment createPayment(Double total, String currency, PaypalPaymentMethod method, PaypalPaymentIntent intent, String description, String cancelUrl, String successUrl)
			throws PayPalRESTException;

}
