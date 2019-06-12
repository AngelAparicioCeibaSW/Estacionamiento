package com.ceiba.adn.estacionamiento.domain.services;

import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.entity.ArgumentValidator;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.exception.ParkingException;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

@Component
public class UpdateTicketService {
	
	private ParkingRepository parkingRepository;
	private static final String VEHICLE_NOT_IN_PARKING = "Este vehiculo no se encuentra en el parqueadero";
	private static final String PLEASE_ENTER_LICENSEPLATE = "Se debe ingresar la placa para poder registrar la salida de un vehiculo";
	
	public UpdateTicketService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}
	
	public float registerExit(String licensePlate) {
		ArgumentValidator.validateRequired(licensePlate, PLEASE_ENTER_LICENSEPLATE);
		Ticket ticket = validateRegister(licensePlate);
		Float price = new Float(20000.10);
		ticket.setPrice(price);
		this.parkingRepository.registerExit(ticket);
		return ticket.getPrice();
	}
	
	private Ticket validateRegister(String licensePlate) {
		Ticket ticket = this.parkingRepository.returnExits(licensePlate);
    	if(ticket == null) {
    		throw new ParkingException(VEHICLE_NOT_IN_PARKING);
    	}
    	return ticket;
	}

}
