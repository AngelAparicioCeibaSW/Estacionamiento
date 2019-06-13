package com.ceiba.adn.estacionamiento.domain.exception;

public class VehicleInParkingException extends RuntimeException {
	
	private static final long serialVersionUID = 54671L;

	public VehicleInParkingException(String msg) {
		super(msg);
	}
	
}
