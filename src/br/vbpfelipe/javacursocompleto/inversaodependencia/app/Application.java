package br.vbpfelipe.javacursocompleto.inversaodependencia.app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.vbpfelipe.javacursocompleto.inversaodependencia.app.entity.Contract;
import br.vbpfelipe.javacursocompleto.inversaodependencia.app.entity.Installment;
import br.vbpfelipe.javacursocompleto.inversaodependencia.service.ContractService;
import br.vbpfelipe.javacursocompleto.inversaodependencia.service.PayPalService;

public class Application {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados o contrato: ");
		System.out.print("Numero: "); 
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): "); 
		LocalDate date = LocalDate.parse(sc.next(), fmt); 
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contract obj = new Contract(number, date, totalValue);
		System.out.print("Entre com o numero de prcelas: "); 
		int parcelas = sc.nextInt();
		
		ContractService contractService = new ContractService(new PayPalService());
		
		contractService.processContract(obj, parcelas);
		
		System.out.println("Parcelas: "); 
		for(Installment installment : obj.getInstallments()) { 
			System.out.println(installment.toString()); 
		}
		
//		Contract obj = new Contract(8028, LocalDate.parse("25/06/2023", fmt), 600.00);
//		ContractService contractService = new ContractService(new PayPalService());
//		contractService.processContract(obj, 3);
//		
//		System.out.println("Parcelas: ");
//		for(Installment installment : obj.getInstallments()) {
//			System.out.println(installment.toString());
//		}
	}
}
