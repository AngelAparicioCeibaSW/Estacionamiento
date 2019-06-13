package com.ceiba.adn.estacionamiento.domain.exception;

public class IncomeNotAllowedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public IncomeNotAllowedException(String msg) {
		super(msg);
	}
}
