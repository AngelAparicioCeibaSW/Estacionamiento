package com.ceiba.adn.estacionamiento.domain.services;

import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.entity.ArgumentValidator;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.exception.VehicleInParkingException;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

@Component
public class UpdateTicketService {

	private ParkingRepository parkingRepository;
	private static final String VEHICLE_NOT_IN_PARKING = "Este vehiculo no se encuentra en el parqueadero";
	private static final String LICENSEPLATE_IS_EMPTY = "Se debe ingresar la placa para poder registrar la salida de un vehiculo";
	private static final float PRICE_CAR_HOUR = 1000;
	private static final float PRICE_CAR_DAY = 8000;
	private static final float PRICE_MOTORCYCLE_HOUR = 500;
	private static final float PRICE_MOTORCYCLE_DAY = 4000;
	private static final float PRICE_MOTORCYCLE_EXTRA = 2000;

	public UpdateTicketService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}

	public float registerExit(String licensePlate) {
		ArgumentValidator.validateRequired(licensePlate, LICENSEPLATE_IS_EMPTY);
		Ticket ticket = validateRegister(licensePlate);
		Float price = new Float(20000.10);
		ticket.setPrice(price);
		ticket.setStatus(false);
		this.parkingRepository.registerExit(ticket);
		return ticket.getPrice();
	}

	private Ticket validateRegister(String licensePlate) {
		Ticket ticket = this.parkingRepository.returnExits(licensePlate);
		if (ticket == null) {
			throw new VehicleInParkingException(VEHICLE_NOT_IN_PARKING);
		}
		return ticket;
	}

}
