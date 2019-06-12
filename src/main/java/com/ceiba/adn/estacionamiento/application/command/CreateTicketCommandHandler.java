package com.ceiba.adn.estacionamiento.application.command;


import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.application.common.CommandResponse;
import com.ceiba.adn.estacionamiento.application.common.commandhandleresponse.CommandHandleResponse;
import com.ceiba.adn.estacionamiento.application.factory.TicketFactory;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.services.CreateTicketService;

@Component
public class CreateTicketCommandHandler implements CommandHandleResponse<TicketCommand, CommandResponse<Ticket>>{

	private final TicketFactory factory;
	private final CreateTicketService createTicketService;
	
	
	public CreateTicketCommandHandler(TicketFactory factory,CreateTicketService createTicketService) {
		this.factory = factory;
		this.createTicketService = createTicketService;
	}

	public CommandResponse<Ticket> exec(TicketCommand command) {
		Ticket ticket= this.factory.create(command);
		return new CommandResponse<>(this.createTicketService.registerIncome(ticket));
	}


}
