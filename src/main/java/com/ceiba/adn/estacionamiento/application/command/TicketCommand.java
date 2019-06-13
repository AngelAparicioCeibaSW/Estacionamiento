package com.ceiba.adn.estacionamiento.application.command;


import lombok.Data;

@Data
public class TicketCommand {
	
	private String licensePlate;
	private String displacement;
	private String typeVehicle;

}
