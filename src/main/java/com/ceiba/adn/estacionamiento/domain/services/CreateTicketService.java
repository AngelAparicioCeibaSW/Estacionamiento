package com.ceiba.adn.estacionamiento.domain.services;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.exception.ParkingException;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

public class CreateTicketService {

	private ParkingRepository parkingRepository;
	public static final String INCOME_NOT_ALLOWED = "Este vehiculo solo puede ingresar los dias domingo y lunes";
	public static final String INVALID_VEHICLE_TYPE = "Este tipo de vehiculo no esta permitido en el parqueadero";
	public static final float PRICE_CAR_HOUR = 1000;
	public static final float PRICE_CAR_DAY = 8000;
	public static final float PRICE_MOTORCYCLE_HOUR = 500;
	public static final float PRICE_MOTORCYCLE_DAY = 4000;
	public static final float PRICE_MOTORCYCLE_EXTRA = 2000;
	public static final String VEHICLE_IN_PARKING = "Este vehiculo ya se encuentra en el parqueadero";
	public static final int MAXIMUM_CAPACITY_OF_MOTORCYCLES = 10; 
	public static final int MAXIMUM_CAPACITY_OF_CARS = 20; 
	public static final String FULL_PARKING = "En este momento no hay espacios disponibles para este tipo de vehiculo";

	public CreateTicketService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}

	public Ticket registerIncome(Ticket ticket) {
		validateRegister(ticket.getLicensePlate());
		return this.parkingRepository.registerIncome(ticket);
	}

	private void validateRegister(String licensePlate) {
		boolean existe = this.parkingRepository.validateExits(licensePlate);
    	if(existe) {
    		throw new ParkingException(VEHICLE_IN_PARKING);
    	}
	}

}
