package com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;

public interface ParkingRepositoryJPA extends JpaRepository<TicketEntity, Long> {
	
	@Query("select te from TicketEntity te where te.status = true")
	List<TicketEntity> activeTickets();
	

}
