package com.ceiba.adn.estacionamiento.domain.services;

import org.springframework.stereotype.Service;

import com.ceiba.adn.estacionamiento.application.domain.TicketApplication;
import com.ceiba.adn.estacionamiento.domain.core.Parking;
import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;




@Service
public class ParkingService {
	
	private Parking parking;
	public static final String INCOME_NOT_ALLOWED= "Este vehiculo solo puede ingresar los dias domingo y lunes";
	public static final String INVALID_VEHICLE_TYPE = "Este tipo de vehiculo no esta permitido en el parqueadero";

	public ParkingService(Parking parking) {
		this.parking = parking;
	}
	
	public TicketDomain registerIncome(TicketApplication ticket) {
		System.out.print(ticket.getDisplacement());
		TicketDomain domain = new TicketDomain();
		//aca van las primeras validaciones
		return parking.registerIncome(domain);
	}

}
