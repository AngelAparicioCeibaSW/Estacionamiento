package com.ceiba.adn.estacionamiento.domain.exception;

public class VehicleNotInParkingException extends RuntimeException {
	
	private static final long serialVersionUID = 54671L;

	public VehicleNotInParkingException(String msg) {
		super(msg);
	}
	
}
