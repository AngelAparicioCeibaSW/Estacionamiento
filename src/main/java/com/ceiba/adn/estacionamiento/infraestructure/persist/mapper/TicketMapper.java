package com.ceiba.adn.estacionamiento.infraestructure.persist.mapper;

import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;
import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;

public class TicketMapper {
	
	private TicketMapper() {
	}
	
	private static final TicketMapper INSTANCE = new TicketMapper();
	
	public static TicketMapper getInstance() {
		return INSTANCE;
	}
	public TicketDomain toDomain(TicketEntity entity) {
		TicketDomain domain = new TicketDomain();
		domain.setDisplacement(entity.getDisplacement());
		domain.setEntry(entity.getEntry());
		domain.setExit(entity.getExit());
		domain.setId(entity.getId());
		domain.setLicensePlate(entity.getLicensePlate());
		domain.setPrice(entity.getPrice());
		domain.setStatus(entity.isStatus());
		domain.setTypeVehicle(entity.getTypeVehicle());
		return domain;
	}
	
	public TicketEntity toEntity(TicketDomain domain) {
		TicketEntity entity = new TicketEntity();
		entity.setDisplacement(domain.getDisplacement());
		entity.setEntry(domain.getEntry());
		entity.setExit(domain.getExit());
		entity.setId(domain.getId());
		entity.setLicensePlate(domain.getLicensePlate());
		entity.setPrice(domain.getPrice());
		entity.setStatus(domain.isStatus());
		entity.setTypeVehicle(domain.getTypeVehicle());
		return entity;
	}

}
