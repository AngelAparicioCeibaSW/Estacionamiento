package com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.entity.TicketActive;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;
import com.ceiba.adn.estacionamiento.infraestructure.persist.mapper.TicketMapper;
import com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.jpa.ParkingRepositoryJPA;

@Component
public class ParkingRepositoryImpl implements ParkingRepository {

	private TicketMapper mapper = TicketMapper.getInstance();

	@Autowired
	private ParkingRepositoryJPA jpa;

	@Override
	public Ticket registerIncome(Ticket ticket) {
		TicketEntity entity = mapper.toEntity(ticket);
		jpa.save(entity);
		return mapper.toDomain(entity);
	}

	@Override
	public List<TicketActive> findActiveTickets() {
		List<TicketActive> tickets = new ArrayList<>();
		tickets = jpa.activeTickets();
		return tickets;
	}

	@Override
	public boolean registerExit(Ticket ticket) {
		TicketEntity entity = mapper.toEntity(ticket);
		boolean response = true;
		entity = jpa.save(entity);
		if(entity == null) {
			response=false;
		}
		return response;
	}

	@Override
	public boolean validateExits(String licensePlate) {
		return false;
	}

	@Override
	public Ticket returnExits(String licensePlate) {
		TicketEntity entity = jpa.findByLicensePlate(licensePlate);
		Ticket ticket = mapper.toDomain(entity);
		return ticket;
	}

}
