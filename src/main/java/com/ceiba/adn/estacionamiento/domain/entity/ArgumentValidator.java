package com.ceiba.adn.estacionamiento.domain.entity;

import com.ceiba.adn.estacionamiento.domain.exception.ArgumentException;
import com.ceiba.adn.estacionamiento.domain.exception.InvalidVehicleTypeException;

public final class ArgumentValidator {
	
	private static final String IS_EMPTY = "";
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";

	private ArgumentValidator() {}
	
	
	public static void validateRequired(Object value,String message) {
		if(value == null || value.equals(IS_EMPTY)) {
			throw new ArgumentException(message);
		}
	}
	
	public static void validateDateRequired(Object value,String message) {
		if(value == null) {
			throw new ArgumentException(message);
		}
	}
	
	public static void validateTypeVehicle(Object value,String message) {
		if(!value.equals(MOTO) && !value.equals(CARRO)) {
			throw new InvalidVehicleTypeException(message);
		}
	}
}
