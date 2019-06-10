package com.ceiba.adn.estacionamiento.domain.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

@Component
public class Parking {

	@Autowired
	private ParkingRepository parkingRepository;
	public static final float PRICE_CAR_HOUR = 1000;
	public static final float PRICE_CAR_DAY = 8000;
	public static final float PRICE_MOTORCYCLE_HOUR = 500;
	public static final float PRICE_MOTORCYCLE_DAY = 4000;
	public static final float PRICE_MOTORCYCLE_EXTRA = 2000;
	public static final String VEHICLE_IN_PARKING = "Este vehiculo ya se encuentra en el parqueadero";
	public static final int MAXIMUM_CAPACITY_OF_MOTORCYCLES = 10; 
	public static final int MAXIMUM_CAPACITY_OF_CARS = 20; 
	public static final String FULL_PARKING = "En este momento no hay espacios disponibles para este tipo de vehiculo";
	
	
	public TicketDomain registerIncome(TicketDomain ticket) {
		//aca van las logicas y excepciones
		return null;
	}
	
	public TicketDomain registerExit() {
		return null;
	}
	
	public boolean allowIncome() {	
		return false;
	}
	
	public float calculatePrice() {
		return 0;
	}
	
	public boolean vehicleInParking() {
		return false;
	}
}
