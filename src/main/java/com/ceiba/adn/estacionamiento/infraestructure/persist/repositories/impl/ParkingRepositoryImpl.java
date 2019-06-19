package com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.application.query.TicketActiveQuery;
import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;
import com.ceiba.adn.estacionamiento.infraestructure.persist.mapper.TicketMapper;
import com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.jpa.ParkingRepositoryJPA;

@Component
public class ParkingRepositoryImpl implements ParkingRepository {

	private static final TicketMapper mapper = TicketMapper.getInstance();
	
	@Autowired
	private ParkingRepositoryJPA jpa;

	@Override
	public Ticket registerIncome(Ticket ticket) {
		TicketEntity entity = mapper.toEntity(ticket);
		return mapper.toDomain(jpa.save(entity));
	}

	@Override
	public List<TicketActiveQuery> findActiveTickets() {
		return jpa.activeTickets();
	}

	@Override
	public boolean registerExit(Ticket ticket) {
		TicketEntity entity = mapper.toEntity(ticket);
		return jpa.save(entity) != null;
	}

	@Override
	public boolean validateExits(String licensePlate) {
		TicketEntity entity = jpa.findByLicensePlate(licensePlate);
		return entity != null;
	}

	@Override
	public Ticket returnExits(String licensePlate) {
		TicketEntity entity = jpa.findByLicensePlate(licensePlate);
		return mapper.toDomain(entity);
	}

	@Override
	public long countActiveCars() {
		return jpa.countActiveCars();
	}

	@Override
	public long countActiveMotorcycles() {
		return jpa.countActiveMotorcycles();
	}

}
