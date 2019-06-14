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
	private static final String MOTO = "MOTO";
	private static final String DISPLACEMENT = "300";
	private static final int DIAS_PRUEBA = 1;
	private static final int HORAS_PRUEBA = 3;
	
	@Before
	public void setUp() {
		// arrange
		this.parking = mock(ParkingRepository.class);
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
	
	
	@Test
	public void calculatePriceMotorcycle() {
		// arrange
		Calendar ahoraCal = Calendar.getInstance();
		ahoraCal.set(ahoraCal.get(Calendar.YEAR), ahoraCal.get(Calendar.MONTH), ahoraCal.get(Calendar.DATE)-DIAS_PRUEBA,ahoraCal.get(Calendar.HOUR),0);
		Date entry = ahoraCal.getTime();
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT).whitLicensePlate(LICENSEPLATE)
				.whitTypeVehicle(MOTO).whitEntry(entry);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.returnExits(LICENSEPLATE)).thenReturn(this.ticket);
		this.service = new 	UpdateTicketService(this.parking);
		// act
		Float price = this.service.registerExit(LICENSEPLATE);
		// assert
		assertEquals(6000, price, 0);
	}
	
	
	
}