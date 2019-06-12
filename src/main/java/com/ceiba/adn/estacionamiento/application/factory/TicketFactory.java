package com.ceiba.adn.estacionamiento.application.factory;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.application.command.TicketCommand;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;

@Component
public class TicketFactory {


	public Ticket create(TicketCommand ticketCommand) {
	    return new Ticket(ticketCommand.getLicensePlate(),
	    		ticketCommand.getDisplacement(),
	    		ticketCommand.getTypeVehicle(),
	    		Calendar.getInstance().getTime()
	    );
	}
}
