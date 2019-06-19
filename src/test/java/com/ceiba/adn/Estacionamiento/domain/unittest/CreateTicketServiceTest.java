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
import com.ceiba.adn.estacionamiento.domain.exception.FullParkingException;
import com.ceiba.adn.estacionamiento.domain.exception.IncomeNotAllowedException;
import com.ceiba.adn.estacionamiento.domain.exception.VehicleInParkingException;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.domain.services.CreateTicketService;
import com.ceiba.adn.estacionamiento.domain.testDataBuilder.TicketTestDatabuilder;

public class CreateTicketServiceTest {

	private ParkingRepository parking;
	private CreateTicketService service;
	private TicketTestDatabuilder ticketBuilder;
	private Ticket ticket;
	private Date today;
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";
	private static final String DISPLACEMENT = "300";
	private static final String LICENSEPLATE = "URG-585";
	private static final String LICENSEPLATE_INCOME_NOT_ALLOWED = "ARG-585";
	private static final String INCOME_NOT_ALLOWED = "No esta autorizado a ingresar un dia distinto a domingo o lunes";
	private static final String VEHICLE_IN_PARKING = "Este vehiculo ya se encuentra en el parqueadero";
	private static final long MAXIMUM_CAPACITY_OF_MOTORCYCLES = 10;
	private static final long MAXIMUM_CAPACITY_OF_CARS = 20;
	private static final String FULL_PARKING_MOTORCYCLES = "En este momento no hay espacios disponibles para motos";
	private static final String FULL_PARKING_CARS = "En este momento no hay espacios disponibles para carros";

	@Before
	public void setUp() {
		// arrange
		this.parking = mock(ParkingRepository.class);
		this.today = Calendar.getInstance().getTime();
	}

	@Test
	public void build() {
		// act
		this.service = new CreateTicketService(this.parking);
		// assert
		assertNotNull(this.parking);
		assertNotNull(this.service);
	}

	@Test
	public void createTicketMotorcycle() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT).whitLicensePlate(LICENSEPLATE)
				.whitTypeVehicle(MOTO).whitEntry(today);
		this.ticket = this.ticketBuilder.build();
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT).whitLicensePlate(LICENSEPLATE)
				.whitTypeVehicle(MOTO).whitEntry(today).whitPrice(0).whitStatus(true);
		Ticket ticketNew = this.ticketBuilder.build();
		when(this.parking.registerIncome(this.ticket)).thenReturn(ticketNew);
		this.service = new CreateTicketService(this.parking);
		// act
		Ticket responseTicket = this.service.registerIncome(this.ticket);
		// assert
		assertEquals(responseTicket, ticketNew);
	}

	@Test
	public void createTicketCar() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(today);
		this.ticket = this.ticketBuilder.build();
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(today).whitPrice(0).whitStatus(true);
		Ticket ticketNew = this.ticketBuilder.build();
		when(this.parking.registerIncome(this.ticket)).thenReturn(ticketNew);
		this.service = new CreateTicketService(this.parking);
		// act
		Ticket responseTicket = this.service.registerIncome(this.ticket);
		// assert
		assertEquals(responseTicket, ticketNew);
	}

	@Test
	public void vehicleInParking() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(today);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.validateExits(LICENSEPLATE)).thenReturn(true);
		this.service = new CreateTicketService(this.parking);
		try {
			// act
			this.service.registerIncome(this.ticket);
			fail();
		} catch (VehicleInParkingException e) {
			// assert
			assertEquals(e.getMessage(), VEHICLE_IN_PARKING);
		}
	}
	
	@Test
	public void vehicleNotParking() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(today);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.validateExits(LICENSEPLATE)).thenReturn(false);
		this.service = new CreateTicketService(this.parking);
		try {
			// act
			this.service.registerIncome(this.ticket);
		} catch (VehicleInParkingException e) {
			// assert
			fail();
		}
	}

	@Test
	public void validateNotExits() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(today);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.validateExits(LICENSEPLATE)).thenReturn(true);
		assertEquals(this.parking.validateExits(LICENSEPLATE), true);
	}

	@Test
	public void vehicleNotInParking() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO)
				.whitEntry(today);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.validateExits(LICENSEPLATE)).thenReturn(false);
		this.service = new CreateTicketService(this.parking);
		try {
			// act
			this.service.registerIncome(this.ticket);
		} catch (VehicleInParkingException e) {
			// assert
			fail();
		}
	}

	@Test
	public void validateFullParkingMotorcycles() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT).whitLicensePlate(LICENSEPLATE)
				.whitEntry(today).whitTypeVehicle(MOTO);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.countActiveMotorcycles()).thenReturn(MAXIMUM_CAPACITY_OF_MOTORCYCLES);
		this.service = new CreateTicketService(this.parking);
		try {
			// act
			this.service.registerIncome(this.ticket);
			fail();
		} catch (FullParkingException e) {
			// assert
			assertEquals(e.getMessage(), FULL_PARKING_MOTORCYCLES);
		}
	}

	@Test
	public void validateFullParkingCars() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder().whitLicensePlate(LICENSEPLATE).whitTypeVehicle(CARRO);
		this.ticket = this.ticketBuilder.build();
		when(this.parking.countActiveCars()).thenReturn(MAXIMUM_CAPACITY_OF_CARS);
		this.service = new CreateTicketService(this.parking);
		try {
			// act
			this.service.registerIncome(this.ticket);
			fail();
		} catch (FullParkingException e) {
			// assert
			assertEquals(e.getMessage(), FULL_PARKING_CARS);
		}
	}

	@Test
	public void validateEntryOfVehycles() {
		// arrange
		Calendar ahoraCal = Calendar.getInstance();
		ahoraCal.set(2019, 5, 26);
		Date todayModify = ahoraCal.getTime();
		this.ticketBuilder = new TicketTestDatabuilder().whitDisplacement(DISPLACEMENT)
				.whitLicensePlate(LICENSEPLATE_INCOME_NOT_ALLOWED).whitEntry(todayModify).whitTypeVehicle(MOTO);
		this.ticket = this.ticketBuilder.build();
		this.service = new CreateTicketService(this.parking);
		try {
			// act
			this.service.registerIncome(this.ticket);
			fail();
		} catch (IncomeNotAllowedException e) {
			// assert
			assertEquals(e.getMessage(), INCOME_NOT_ALLOWED);
		}

	}

}
