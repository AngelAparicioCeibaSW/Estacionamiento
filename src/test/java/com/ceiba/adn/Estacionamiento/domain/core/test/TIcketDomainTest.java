package com.ceiba.adn.estacionamiento.domain.core.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.adn.estacionamiento.domain.core.Parking;
import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;
import com.ceiba.adn.estacionamiento.domain.core.testDataBuilder.TicketDomainTestDatabuilder;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

public class TicketDomainTest {

	private TicketDomainTestDatabuilder ticketBuilder;
	private ParkingRepository parkingRepository;
	private TicketDomain ticket;
	private Parking parking;

	/**
	 * Test el cual verifica que el ticket se creo correctamente para una moto
	 */
	@Test
	public void registerIncomeSuccess() {
		// arrange
		this.ticketBuilder = new TicketDomainTestDatabuilder();
		this.ticket = this.ticketBuilder.build();
		this.parkingRepository = mock(ParkingRepository.class);
		Mockito.when(parkingRepository.registerIncome(ticket)).thenReturn(ticket);
		this.parking = new Parking(parkingRepository);
		// act
		TicketDomain response = this.parking.registerIncome(ticket);
		// assert
		assertNotNull(response);
	}

}
