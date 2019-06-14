package com.ceiba.adn.estacionamiento.domain.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ceiba.adn.estacionamiento.domain.entity.ArgumentValidator;
import com.ceiba.adn.estacionamiento.domain.exception.ArgumentException;
import com.ceiba.adn.estacionamiento.domain.exception.InvalidVehicleTypeException;

public class ArgumentValidatorTest {

	private static final String IS_EMPTY = "";
	private static final String AVION = "AVION";
	private static final String LICENSEPLATE_IS_EMPTY = "Se debe ingresar la placa";
	private static final String INVALID_TYPE_VEHICLE = "Se debe ingresar un tipo valido de vehiculo";
	
	@Test
	public void argumentValidatorIsEmpty() {
		try {
			// act
			ArgumentValidator.validateRequired(IS_EMPTY,LICENSEPLATE_IS_EMPTY);
			fail();
		} catch (ArgumentException e) {
			// assert
			assertEquals(e.getMessage(), LICENSEPLATE_IS_EMPTY);
		}
	}
	
	@Test
	public void argumentValidatorIsNull() {
		try {
			// act
			ArgumentValidator.validateRequired(null,LICENSEPLATE_IS_EMPTY);
			fail();
		} catch (ArgumentException e) {
			// assert
			assertEquals(e.getMessage(), LICENSEPLATE_IS_EMPTY);
		}
	}
	
	@Test
	public void argumentValidatorDateIsNull() {
		try {
			// act
			ArgumentValidator.validateDateRequired(null,LICENSEPLATE_IS_EMPTY);
			fail();
		} catch (ArgumentException e) {
			// assert
			assertEquals(e.getMessage(), LICENSEPLATE_IS_EMPTY);
		}
	}
	
	@Test
	public void argumentValidatorInvalidTypeVehicle() {
		try {
			// act
			ArgumentValidator.validateTypeVehicle(AVION,INVALID_TYPE_VEHICLE);
			fail();
		} catch (InvalidVehicleTypeException e) {
			// assert
			assertEquals(e.getMessage(), INVALID_TYPE_VEHICLE);
		}
	}

}
