package com.ceiba.adn.estacionamiento.application.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.application.domain.TicketApplication;
import com.ceiba.adn.estacionamiento.domain.core.Parking;
import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;

import java.util.List;




@Component
public class ParkingService {
	
	@Autowired
	private Parking parking;
	public static final String INCOME_NOT_ALLOWED= "Este vehiculo solo puede ingresar los dias domingo y lunes";
	public static final String INVALID_VEHICLE_TYPE = "Este tipo de vehiculo no esta permitido en el parqueadero";

	public ParkingService(Parking parking) {
		this.parking = parking;
	}
	
	public TicketDomain registerIncome(TicketApplication ticket) {
		TicketDomain domain = new TicketDomain();
		domain.setLicensePlate(ticket.getLicensePlate());
		domain.setDisplacement(Integer.parseInt(ticket.getDisplacement()));
		domain.setTypeVehicle(ticket.getTypeVehicle());
		domain.setEntry(Calendar.getInstance().getTime());
		domain.setStatus(true);
		//aca van las primeras validaciones
		return parking.registerIncome(domain);
	}
	
	public List<TicketDomain> findActiveTickets(){
		return parking.findActiveTickets();
	}

}
