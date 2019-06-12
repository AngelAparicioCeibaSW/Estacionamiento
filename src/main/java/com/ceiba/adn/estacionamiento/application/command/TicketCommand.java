package com.ceiba.adn.estacionamiento.application.command;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketCommand {
	
	private String licensePlate;
	private String displacement;
	private String typeVehicle;

}
