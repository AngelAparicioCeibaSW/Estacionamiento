package com.ceiba.adn.estacionamiento.domain.repository;

import com.ceiba.adn.estacionamiento.application.domain.TicketApplication;
import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;

public interface ParkingRepository {
	
	/**
	 * Método que registra un nuevo ticket
	 * 
	 * @param ticket a registrar
	 * @return ticket registrado en la base de datos con sus respectivos datos
	 */
	public TicketDomain registerIncome(TicketDomain ticket);

}
