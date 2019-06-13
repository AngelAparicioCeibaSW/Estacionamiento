package com.ceiba.adn.estacionamiento.domain.repository;
import java.util.List;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.entity.TicketActive;
public interface ParkingRepository {
	
	/**
	 * Método que registra un nuevo ticket
	 * 
	 * @param ticket a registrar
	 * @return ticket registrado en la base de datos con sus respectivos datos
	 */
	public Ticket registerIncome(Ticket ticket);
	
	/**
	 * Método que lista todos los tickets que se encuentran activos en el parqueadero
	 * @return tickets activos
	 */
	public List<TicketActive> findActiveTickets();
	
	
	/**
	 * Método que registra la finalizaión de un ticket
	 * 
	 * @param ticket a finalizar
	 * @return boolean con true si se finalizo correctamente y false si no
	 */
	public boolean registerExit(Ticket ticket); 
	
	
	/**
	 * Método que verifica si un vehiculo ya se encuentra en el parqueadero
	 * 
	 * @param placa de vehiculo a verificar
	 * @return boolean con la respuesta si se encontro el vehiculo con ticket activo
	 */
	public boolean validateExits(String licensePlate);
	
	/**
	 * Método que retorna un vehiculo del parqueadero que aun no ha salido
	 * 
	 * @param placa de vehiculo a verificar
	 * @return ticket con la respuesta si se encontro el vehiculo con ticket activo
	 */
	public Ticket returnExits(String licensePlate);
	
	/**
	 * Método que retorna la cantidad de vehiculos de tipo carro que se encuentran simultaneamente en el estacionamiento
	 * 
	 * @return cantidad de vehiculos de tipo carro
	 */
	public long countActiveCars();
	
	/**
	 * Método que retorna la cantidad de vehiculos de tipo moto que se encuentran simultaneamente en el estacionamiento
	 * 
	 * @return cantidad de vehiculos de tipo moto
	 */
	public long countActiveMotorcycles();
	
	
	
	
	
	
	
	

}
