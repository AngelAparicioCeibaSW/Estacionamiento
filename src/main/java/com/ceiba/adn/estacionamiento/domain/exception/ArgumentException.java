package com.ceiba.adn.estacionamiento.domain.exception;

public class ArgumentException  extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ArgumentException(String msg) {
		super(msg);
	}
}
