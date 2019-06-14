package com.ceiba.adn.estacionamiento.domain.unitTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.exception.VehicleInParkingException;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.domain.services.UpdateTicketService;
import com.ceiba.adn.estacionamiento.domain.testDataBuilder.TicketTestDatabuilder;

public class UpdateTicketServiceTest {

	private static final String VEHICLE_NOT_IN_PARKING = "Este vehiculo no se encuentra en el parqueadero";
	private static final String LICENSEPLATE = "URG-585";
	private ParkingRepository parking;
	private UpdateTicketService service;
	private TicketTestDatabuilder ticketBuilder;
	private Ticket ticket;
	private Date today;
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";
	
	
	@Before
	public void setUp() {
		// arrange
		this.parking = mock(ParkingRepository.class);
		this.today = Calendar.getInstance().getTime();
	}
	
	@Test
	public void build() {
		// act
		this.service = new UpdateTicketService(this.parking);
		// assert
		assertNotNull(this.parking);
		assertNotNull(this.service);
	}
	
	@Test
	public void vehicleNotInParking() {
		// arrange
		when(this.parking.validateExits(LICENSEPLATE)).thenReturn(false);
		this.service = new UpdateTicketService(this.parking);
		try {
			// act
			this.service.registerExit(LICENSEPLATE);
			fail();
		} catch (VehicleInParkingException e) {
			// assert
			assertEquals(e.getMessage(),VEHICLE_NOT_IN_PARKING);
		}
	}
	
	
	
}