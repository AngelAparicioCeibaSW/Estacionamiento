package com.ceiba.adn.estacionamiento.infraestructure.unitTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;
import com.ceiba.adn.estacionamiento.infraestructure.testDataBuilder.TicketEntityDataBuilder;

public class TicketEntityTest {

	private TicketEntityDataBuilder ticketBuilder;
	private TicketEntity ticket;
	private static final String TYPE_VEHICLE_MOTO = "MOTO";
	private static final String DISPLACEMENT_MOTO = "500";
	private static final String TYPE_VEHICLE_CARRO = "CARRO";
	private static final String DISPLACEMENT_CARRO = "500";

	/**
	 * 
	 * Test el cual verifica que el ticket entity  se creo correctamente para una moto
	 */
	@Test
	public void createTicketMoto() {
		// arrange
		this.ticketBuilder = new TicketEntityDataBuilder().whitTypeVehicle(TYPE_VEHICLE_MOTO).whitDisplacement(DISPLACEMENT_MOTO);
		// act
		this.ticket = this.ticketBuilder.build();
		assertNotNull(ticket);
	}
	
	/**
	 * 
	 * Test el cual verifica que el ticket entity se creo correctamente para un carro
	 */
	@Test
	public void createTicketCarro() {
		// arrange
		this.ticketBuilder = new TicketEntityDataBuilder().whitTypeVehicle(TYPE_VEHICLE_CARRO).whitDisplacement(DISPLACEMENT_CARRO);
		// act
		this.ticket = this.ticketBuilder.build();
		assertNotNull(ticket);
	}

}
