package com.ceiba.adn.estacionamiento.application.command;

import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.application.common.CommandResponse;
import com.ceiba.adn.estacionamiento.application.common.commandhandleresponse.CommandHandleResponse;
import com.ceiba.adn.estacionamiento.domain.services.UpdateTicketService;

@Component
public class UpdateTicketCommandHandler implements CommandHandleResponse<String, CommandResponse<Float>> {

	private final UpdateTicketService updateTicketService;

	public UpdateTicketCommandHandler(UpdateTicketService updateTicketService) {
		this.updateTicketService = updateTicketService;
	}

	@Override
	public CommandResponse<Float> exec(String licensePlate) {
		return new CommandResponse<>(updateTicketService.registerExit(licensePlate));
	}

}
