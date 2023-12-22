package br.vbpfelipe.javacursocompleto.inversaodependencia.app.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDate dueDte;
	private Double amount;
	
	public Installment(LocalDate dueDte, Double amount) {
		super();
		this.dueDte = dueDte;
		this.amount = amount;
	}

	public LocalDate getDueDte() {
		return dueDte;
	}

	public void setDueDte(LocalDate dueDte) {
		this.dueDte = dueDte;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return this.dueDte.format(this.fmt) + " - " + String.format("%.2f",this.amount);
	}	
	
}
