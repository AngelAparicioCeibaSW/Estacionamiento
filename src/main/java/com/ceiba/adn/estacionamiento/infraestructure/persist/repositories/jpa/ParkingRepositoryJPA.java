package com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ceiba.adn.estacionamiento.application.query.TicketActiveQuery;
import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;

public interface ParkingRepositoryJPA extends CrudRepository<TicketEntity, Long> {
	
	@Query("select new com.ceiba.adn.estacionamiento.application.query.TicketActiveQuery(te.licensePlate,te.entry,te.typeVehicle) from TicketEntity te where te.status = true")
	List<TicketActiveQuery> activeTickets();
	
	@Query("select te  from TicketEntity te where te.status = true and te.licensePlate = :licensePlate")
	TicketEntity findByLicensePlate(@Param("licensePlate") String licensePlate);
	
	@Query("select count(*) from TicketEntity te where te.typeVehicle = 'MOTO' and te.status = true")
	long countActiveMotorcycles();
	
	@Query("select count(*) from TicketEntity te where te.typeVehicle = 'CARRO' and te.status = true")
	long countActiveCars();

}
