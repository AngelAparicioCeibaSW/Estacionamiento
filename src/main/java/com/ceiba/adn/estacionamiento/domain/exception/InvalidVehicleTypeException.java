package com.ceiba.adn.estacionamiento.domain.exception;

public class InvalidVehicleTypeException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidVehicleTypeException(String msg) {
		super(msg);
	}

}
