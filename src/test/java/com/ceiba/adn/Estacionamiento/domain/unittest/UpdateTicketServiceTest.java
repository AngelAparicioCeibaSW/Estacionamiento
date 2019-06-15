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
	private static final String CARRO = "CARRO";
	private static final String DISPLACEMENT_EXTRA = "600";
	private static final String DISPLACEMENT = "300";
	private static final int DAYS_TEST_CAR = 1;
	private static final int HOURS_TEST_CAR = 3;
	private static final int DAYS_TEST_MOTORCYCLE = 0;
	private static final int HOURS_TEST_MOTORCYCLE = 10;
	private static final float PRICE_TEST_MOTORCYCLE = 4000;
	private static final float PRICE_TEST_MOTORCYCLE_EXTRA = 6000;
	private static final float PRICE_TEST_CAR = 11000;
	
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
			assertEquals(e.getMessage(), VEHICLE_NOT_IN_PARKING);
		}
	}

	@Test
	public void registerExitMotorcycleExtra() {
		// arrange
		Calendar ahoraCal = Calendar.getInstance();
		ahoraCal.set(ahoraCal.get(Calendar.YEAR), ahoraCal.get(Calendar.MONTH),
				ahoraCal.get(Calendar.DATE) - DAYS_TEST_MOTORCYCLE,
				ahoraCal.get(Calendar.HOUR_OF_DAY) - HOURS_TEST_MOTORCYCLE, 0);
		Date entry = ahoraCal.getTime();
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT_EXTRA)
				.whitLicensePlate(LICENSEPLATE).whitTypeVehicle(MOTO).whitEntry(entry);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.returnExits(LICENSEPLATE)).thenReturn(this.ticket);
		when(this.parking.registerExit(this.ticket)).thenReturn(true);
		this.service = new UpdateTicketService(this.parking);
		// act
		Float price = this.service.registerExit(LICENSEPLATE);
		boolean exit = this.parking.registerExit(this.ticket);
		// assert
		assertEquals(PRICE_TEST_MOTORCYCLE_EXTRA, price, 0);
		assertEquals(true, exit);
	}

	@Test
	public void registerExitMotorcycle() {
		// arrange
		Calendar ahoraCal = Calendar.getInstance();
		ahoraCal.set(ahoraCal.get(Calendar.YEAR), ahoraCal.get(Calendar.MONTH),
				ahoraCal.get(Calendar.DATE) - DAYS_TEST_MOTORCYCLE,
				ahoraCal.get(Calendar.HOUR_OF_DAY) - HOURS_TEST_MOTORCYCLE, 0);
		Date entry = ahoraCal.getTime();
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT).whitLicensePlate(LICENSEPLATE)
				.whitTypeVehicle(MOTO).whitEntry(entry);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.returnExits(LICENSEPLATE)).thenReturn(this.ticket);
		when(this.parking.registerExit(this.ticket)).thenReturn(true);
		this.service = new UpdateTicketService(this.parking);
		// act
		Float price = this.service.registerExit(LICENSEPLATE);
		boolean exit = this.parking.registerExit(this.ticket);
		// assert
		assertEquals(PRICE_TEST_MOTORCYCLE, price, 0);
		assertEquals(true, exit);
	}

	@Test
	public void registerExitCar() {
		// arrange
		Calendar ahoraCal = Calendar.getInstance();
		ahoraCal.set(ahoraCal.get(Calendar.YEAR), ahoraCal.get(Calendar.MONTH),
				ahoraCal.get(Calendar.DATE) - DAYS_TEST_CAR, ahoraCal.get(Calendar.HOUR_OF_DAY) - HOURS_TEST_CAR, 0);
		Date entry = ahoraCal.getTime();
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(entry);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.returnExits(LICENSEPLATE)).thenReturn(this.ticket);
		when(this.parking.registerExit(this.ticket)).thenReturn(true);
		this.service = new UpdateTicketService(this.parking);
		// act
		Float price = this.service.registerExit(LICENSEPLATE);
		boolean exit = this.parking.registerExit(this.ticket);
		// assert
		assertEquals(PRICE_TEST_CAR, price, 0);
		assertEquals(true, exit);
	}
	

}