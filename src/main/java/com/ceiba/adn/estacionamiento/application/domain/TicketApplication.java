package com.ceiba.adn.estacionamiento.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketApplication {
	
	private String licensePlate;
	private String displacement;
	private String typeVehicle;
	
}
