package com.ceiba.adn.estacionamiento.application.command;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TicketCommand {
	
	private String licensePlate;
	private String displacement;
	private String typeVehicle;

}
