package com.ceiba.adn.estacionamiento.domain.repository;
import java.util.List;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.entity.TicketActive;
public interface ParkingRepository {
	
	/**
	 * M�todo que registra un nuevo ticket
	 * 
	 * @param ticket a registrar
	 * @return ticket registrado en la base de datos con sus respectivos datos
	 */
	public Ticket registerIncome(Ticket ticket);
	
	/**
	 * M�todo que lista todos los tickets que se encuentran activos en el parqueadero
	 * @return tickets activos
	 */
	public List<TicketActive> findActiveTickets();
	
	
	/**
	 * M�todo que registra la finalizai�n de un ticket
	 * 
	 * @param ticket a finalizar
	 * @return boolean con true si se finalizo correctamente y false si no
	 */
	public boolean registerExit(Ticket ticket); 
	
	
	/**
	 * M�todo que verifica si un vehiculo ya se encuentra en el parqueadero
	 * 
	 * @param placa de vehiculo a verificar
	 * @return boolean con la respuesta si se encontro el vehiculo con ticket activo
	 */
	public boolean validateExits(String licensePlate);
	
	/**
	 * M�todo que retorna un vehiculo del parqueadero que aun no ha salido
	 * 
	 * @param placa de vehiculo a verificar
	 * @return ticket con la respuesta si se encontro el vehiculo con ticket activo
	 */
	public Ticket returnExits(String licensePlate);
	
	
	
	
	
	
	
	

}
