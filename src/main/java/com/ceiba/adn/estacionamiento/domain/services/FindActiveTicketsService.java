package com.ceiba.adn.estacionamiento.domain.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.adn.estacionamiento.domain.entity.TicketActive;
import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;

@Component
public class FindActiveTicketsService {
	
	private ParkingRepository parkingRepository;
	
	public FindActiveTicketsService(ParkingRepository parkingRepository) {
		this.parkingRepository = parkingRepository;
	}
	
	public List<TicketActive> findActiveTickets(){
		return this.parkingRepository.findActiveTickets();
	}

}
