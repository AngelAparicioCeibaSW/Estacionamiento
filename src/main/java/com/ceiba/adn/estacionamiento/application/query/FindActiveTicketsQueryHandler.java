package com.ceiba.adn.estacionamiento.application.query;

import java.util.List;
import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.entity.TicketActive;
import com.ceiba.adn.estacionamiento.domain.services.FindActiveTicketsService;

@Component
public class FindActiveTicketsQueryHandler{

	private final FindActiveTicketsService findActiveTicketsService;

	public FindActiveTicketsQueryHandler(FindActiveTicketsService findActiveTicketsService) {
		this.findActiveTicketsService = findActiveTicketsService;
	}
	
	public List<TicketActive> exec(){
		return this.findActiveTicketsService.findActiveTickets();
	}
}
