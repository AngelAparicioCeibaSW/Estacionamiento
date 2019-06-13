package com.ceiba.adn.estacionamiento.infraestructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.adn.estacionamiento.application.command.CreateTicketCommandHandler;
import com.ceiba.adn.estacionamiento.application.command.TicketCommand;
import com.ceiba.adn.estacionamiento.application.command.UpdateTicketCommandHandler;
import com.ceiba.adn.estacionamiento.application.common.CommandResponse;
import com.ceiba.adn.estacionamiento.application.query.FindActiveTicketsQueryHandler;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.entity.TicketActive;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/ticket")
@Api(tags = { "Controller tickets"})
public class ParkingController {
	
	private final CreateTicketCommandHandler createTicketCommandHandler;
	private final UpdateTicketCommandHandler updateTicketCommandHandler;
	private final FindActiveTicketsQueryHandler findActiveTicketsQueryHandler;
	
	@Autowired
	public ParkingController(CreateTicketCommandHandler createTicketCommandHandler,
			UpdateTicketCommandHandler updateTicketCommandHandler,
			FindActiveTicketsQueryHandler findActiveTicketsQueryHandler) {
		this.createTicketCommandHandler = createTicketCommandHandler;
		this.updateTicketCommandHandler = updateTicketCommandHandler;
		this.findActiveTicketsQueryHandler = findActiveTicketsQueryHandler;
	}
	
	@PostMapping
	@ApiOperation("Save Ticket")
	public CommandResponse<Ticket> post(@RequestBody TicketCommand command) {
		return createTicketCommandHandler.exec(command);
	}
	

	@GetMapping
	@ApiOperation("Active Tickets")
	public List<TicketActive> get() {
		return this.findActiveTicketsQueryHandler.exec();
	}
	
	@PatchMapping(value="/{licensePlate}")
	@ApiOperation("Update Ticket")
	public CommandResponse<Float> put(@PathVariable String licensePlate) {
		return this.updateTicketCommandHandler.exec(licensePlate);
	}
	

	

}
