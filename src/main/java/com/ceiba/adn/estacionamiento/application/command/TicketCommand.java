package com.ceiba.adn.estacionamiento.application.command;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketCommand {
	
	private String licensePlate;
	private String displacement;
	private String typeVehicle;

}
