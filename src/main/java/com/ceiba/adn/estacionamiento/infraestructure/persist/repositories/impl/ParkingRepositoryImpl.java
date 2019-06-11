package com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;
import com.ceiba.adn.estacionamiento.infraestructure.persist.mapper.TicketMapper;
import com.ceiba.adn.estacionamiento.infraestructure.persist.repositories.jpa.ParkingRepositoryJPA;

@Component
public class ParkingRepositoryImpl implements ParkingRepository{

	private TicketMapper mapper = TicketMapper.getInstance();
	
	@Autowired
	private ParkingRepositoryJPA jpa ;
	
	@Override
	public TicketDomain registerIncome(TicketDomain ticket) {
		TicketEntity entity = mapper.toEntity(ticket);
		jpa.save(entity);
		return mapper.toDomain(entity);
	}

	@Override
	public List<TicketDomain> findActiveTickets() {
		List<TicketDomain> tickets = new ArrayList<>();
		jpa.activeTickets().forEach(entity -> 
		tickets.add(mapper.toDomain(entity)));
		return tickets;
	}

	
}
