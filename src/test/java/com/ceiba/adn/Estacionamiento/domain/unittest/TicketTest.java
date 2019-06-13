package com.ceiba.adn.estacionamiento.domain.unitTest;

import static org.junit.Assert.assertNotNull;

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

	/**
	 * 
	 * Test el cual verifica que el ticket se creo correctamente para una moto
	 */
	@Test
	public void createTicketMoto() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitTypeVehicle(TYPE_VEHICLE_MOTO).whitDisplacement(DISPLACEMENT_MOTO);
		// act
		this.ticket = this.ticketBuilder.build();
		assertNotNull(ticket);
	}
	
	/**
	 * 
	 * Test el cual verifica que el ticket se creo correctamente para un carro
	 */
	@Test
	public void createTicketCarro() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitTypeVehicle(TYPE_VEHICLE_CARRO).whitDisplacement(DISPLACEMENT_CARRO);
		// act
		this.ticket = this.ticketBuilder.build();
		assertNotNull(ticket);
	}

}
