package br.vbpfelipe.javacursocompleto.inversaodependencia.service;

import java.time.LocalDate;

import br.vbpfelipe.javacursocompleto.inversaodependencia.app.entity.Contract;
import br.vbpfelipe.javacursocompleto.inversaodependencia.app.entity.Installment;

public class ContractService {
	
	private OnlinePaymentService service;

	public ContractService(OnlinePaymentService service) {
		this.service = service;
	}

	public OnlinePaymentService getService() {
		return service;
	}

	public void setService(OnlinePaymentService service) {
		this.service = service;
	}
	
	public void processContract(Contract contract, Integer months) {
		
		double basicQuota = contract.getTotalValue() / months;
		
		for(int i=1; i<=months; i++) {
			
			contract.getInstallments().add(new Installment(contract.getDate().plusMonths(i), service.paymentFee(service.interest(basicQuota, i))));
		}
		
	}
	
}
