package com.ceiba.adn.estacionamiento.infraestructure.integration.testDatabuilder;

import com.ceiba.adn.estacionamiento.application.command.TicketCommand;

public class TicketCommandDataBuilder {

	private String licensePlate;
	private String displacement;
	private String typeVehicle;

	public TicketCommandDataBuilder() {
	}

	public TicketCommandDataBuilder whitLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;
	}

	public TicketCommandDataBuilder whitDisplacement(String displacement) {
		this.displacement = displacement;
		return this;
	}

	public TicketCommandDataBuilder whitTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}

	public TicketCommand build() {
		TicketCommand ticket = new TicketCommand();
		ticket.setDisplacement(this.displacement);
		ticket.setLicensePlate(this.licensePlate);
		ticket.setTypeVehicle(this.typeVehicle);
		return ticket;
	}
}
