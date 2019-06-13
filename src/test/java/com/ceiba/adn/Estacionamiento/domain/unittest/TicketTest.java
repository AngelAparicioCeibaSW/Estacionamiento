package com.ceiba.adn.estacionamiento.domain.unitTest;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.testDataBuilder.TicketTestDatabuilder;

public class TicketTest {

	private TicketTestDatabuilder ticketBuilder;
	private Ticket ticket;
	private static final String TYPE_VEHICLE_MOTO = "MOTO";
	private static final String DISPLACEMENT_MOTO = "500";
	private static final String TYPE_VEHICLE_CARRO = "CARRO";
	private static final String DISPLACEMENT_CARRO = "500";
	private static final boolean REGISTERED_SUCCESS = true;
	private static final Date ENTRY = Calendar.getInstance().getTime();
	private static final String LICENSEPLATE_MOTO = "URG-243";
	private static final String LICENSEPLATE_CARRO = "URG-585";

	/**
	 * 
	 * Test el cual verifica que el ticket se creo correctamente para una moto
	 */
	@Test
	public void createTicketMoto() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE_MOTO)
				.whitTypeVehicle(TYPE_VEHICLE_MOTO).whitDisplacement(DISPLACEMENT_MOTO).whitStatus(REGISTERED_SUCCESS)
				.whitEntry(ENTRY);
		// act
		this.ticket = this.ticketBuilder.build();
		// assert
		assertNotNull(ticket);
	}

	/**
	 * 
	 * Test el cual verifica que el ticket se creo correctamente para un carro
	 */
	@Test
	public void createTicketCarro() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE_CARRO)
				.whitTypeVehicle(TYPE_VEHICLE_CARRO).whitDisplacement(DISPLACEMENT_CARRO).whitStatus(REGISTERED_SUCCESS);
		// act
		this.ticket = this.ticketBuilder.build();
		// assert
		assertNotNull(ticket);
	}

}
