package com.ceiba.adn.estacionamiento.application.mapper;

import com.ceiba.adn.estacionamiento.application.command.TicketCommand;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;

public final class TicketCommandMapper {

	private TicketCommandMapper() {
	}

	private static final TicketCommandMapper INSTANCE = new TicketCommandMapper();

	public static TicketCommandMapper getInstance() {
		return INSTANCE;
	}

	public TicketCommand toCommand(Ticket entity) {
		TicketCommand domain = new TicketCommand();
		domain.setDisplacement(entity.getDisplacement());
		domain.setLicensePlate(entity.getLicensePlate());
		domain.setTypeVehicle(entity.getTypeVehicle());
		return domain;
	}


}
