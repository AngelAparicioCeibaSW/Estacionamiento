package com.ceiba.adn.estacionamiento.domain.services;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.exception.FullParkingException;
import com.ceiba.adn.estacionamiento.domain.exception.IncomeNotAllowedException;
import com.ceiba.adn.estacionamiento.domain.exception.VehicleInParkingException;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

public class CreateTicketService {

	private ParkingRepository parkingRepository;
	private static final String INCOME_NOT_ALLOWED = "No esta autorizado a ingresar un dia distinto a domingo o lunes";
	private static final String VEHICLE_IN_PARKING = "Este vehiculo ya se encuentra en el parqueadero";
	private static final long MAXIMUM_CAPACITY_OF_MOTORCYCLES = 10;
	private static final long MAXIMUM_CAPACITY_OF_CARS = 20;
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";
	private static final String FIRST_LETTER_LICENSEPLATE = "A";
	private static final String FULL_PARKING_MOTORCYCLES = "En este momento no hay espacios disponibles para motos";
	private static final String FULL_PARKING_CARS = "En este momento no hay espacios disponibles para carros";

	public CreateTicketService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}

	public Ticket registerIncome(Ticket ticket) {
		validateRegister(ticket.getLicensePlate());
		validateFullParking(ticket.getTypeVehicle());
		validateEntryOfVehycles(ticket.getLicensePlate(),ticket.getEntry());
		return this.parkingRepository.registerIncome(ticket);
	}

	private void validateRegister(String licensePlate) {
		boolean existe = this.parkingRepository.validateExits(licensePlate);
		if (existe) {
			throw new VehicleInParkingException(VEHICLE_IN_PARKING);
		}
	}

	private void validateFullParking(String typeVehicle) {
		if (typeVehicle.equals(MOTO)
				&& this.parkingRepository.countActiveMotorcycles() == MAXIMUM_CAPACITY_OF_MOTORCYCLES) {
			throw new FullParkingException(FULL_PARKING_MOTORCYCLES);
		}
		if (typeVehicle.equals(CARRO) && this.parkingRepository.countActiveCars() == MAXIMUM_CAPACITY_OF_CARS) {
			throw new FullParkingException(FULL_PARKING_CARS);
		}
	}

	private void validateEntryOfVehycles(String licensePlate,Date date) {
		Calendar today = Calendar.getInstance();
		today.setTimeInMillis(date.getTime());
		int day = today.get(Calendar.DAY_OF_WEEK);
		if (licensePlate.startsWith(FIRST_LETTER_LICENSEPLATE) && (day > Calendar.MONDAY)) {
			throw new IncomeNotAllowedException(INCOME_NOT_ALLOWED);
		}
	}

}
