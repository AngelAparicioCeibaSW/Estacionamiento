package com.ceiba.adn.estacionamiento.domain.unittest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.testdatabuilder.TicketTestDatabuilder;

public class TicketTest {

	private TicketTestDatabuilder ticketBuilder;
	private Ticket ticket;
	private final String typeVehicleMoto = "MOTO";
	private final String displacement = "500";

	/**
	 * 
	 * Test el cual verifica que el ticket se creo correctamente para una moto
	 */
	@Test
	public void createTicketMoto() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitTypeVehicle(typeVehicleMoto).whitDisplacement(displacement);
		// act
		this.ticket = this.ticketBuilder.build();
		assertNotNull(ticket);
	}

}
