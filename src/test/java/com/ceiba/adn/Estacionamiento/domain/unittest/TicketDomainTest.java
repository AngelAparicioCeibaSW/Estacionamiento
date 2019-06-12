package com.ceiba.adn.estacionamiento.domain.unittest;

import org.junit.Test;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.domain.testdatabuilder.TicketTestDatabuilder;

public class TicketDomainTest {

	private TicketTestDatabuilder ticketBuilder;
	private ParkingRepository parkingRepository;
	private Ticket ticket;


	/**
	 * Test el cual verifica que el ticket se creo correctamente para una moto
	 */
	@Test
	public void registerIncomeSuccess() {
		// arrange
		/*
		 * this.ticketBuilder = new TicketTestDatabuilder(); this.ticket =
		 * this.ticketBuilder.build(); this.parkingRepository =
		 * mock(ParkingRepository.class);
		 * Mockito.when(parkingRepository.registerIncome(ticket)).thenReturn(ticket);
		 * this.parking = new ParkingService(parkingRepository); // act Ticket response
		 * = this.parking.registerIncome(ticket); // assert assertNotNull(response);
		 */
	}

}
