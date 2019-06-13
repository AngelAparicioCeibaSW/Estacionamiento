package com.ceiba.adn.estacionamiento.domain.exception;

public class FullParkingException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public FullParkingException(String msg) {
		super(msg);
	}
}
