package com.ceiba.adn.estacionamiento.domain.services;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";

	public UpdateTicketService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}

	public float registerExit(String licensePlate) {
		ArgumentValidator.validateRequired(licensePlate, LICENSEPLATE_IS_EMPTY);
		Ticket ticket = validateRegister(licensePlate);
		ticket.setStatus(false);
		ticket.setExit(Calendar.getInstance().getTime());
		ticket.setPrice(calculatePrice(ticket));
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

	private float calculatePrice(Ticket ticket) {
		float price = 0;
		long serviceTime = ticket.getExit().getTime() - ticket.getEntry().getTime();
		serviceTime = TimeUnit.MILLISECONDS.toHours(serviceTime);
		long dias = (serviceTime / 24);
		long horasSobrantes = (serviceTime-(dias*24));
		if(horasSobrantes>=9) {
			dias ++;
			horasSobrantes=0;
		}
		if (ticket.getTypeVehicle().equalsIgnoreCase(MOTO)) {
			price += dias * PRICE_MOTORCYCLE_DAY;
			price += horasSobrantes * PRICE_MOTORCYCLE_HOUR;
			if (Integer.parseInt(ticket.getDisplacement()) > 500) {
				price += PRICE_MOTORCYCLE_EXTRA;
			}
		}
		if (ticket.getTypeVehicle().equalsIgnoreCase(CARRO)) {
			price += dias * PRICE_CAR_DAY;
			price += horasSobrantes * PRICE_CAR_HOUR;
		}
		return price;
	}

}
