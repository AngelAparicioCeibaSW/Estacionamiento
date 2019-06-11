package com.ceiba.adn.estacionamiento.domain.repository;
import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;
import java.util.List;
public interface ParkingRepository {
	
	/**
	 * Método que registra un nuevo ticket
	 * 
	 * @param ticket a registrar
	 * @return ticket registrado en la base de datos con sus respectivos datos
	 */
	public TicketDomain registerIncome(TicketDomain ticket);
	
	/**
	 * Método que lista todos los tickets que se encuentran activos en el parqueadero
	 * @return tickets activos
	 */
	public List<TicketDomain> findActiveTickets();

}
