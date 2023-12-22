package br.vbpfelipe.javacursocompleto.inversaodependencia.service;

public class PayPalService implements OnlinePaymentService{

	@Override
	public Double paymentFee(Double amount) {
		return amount * 1.02;
	}

	@Override
	public Double interest(Double amount, Integer months) {
		return amount + amount * 0.01 * months;
	}

}
