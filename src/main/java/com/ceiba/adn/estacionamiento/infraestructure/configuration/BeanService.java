package com.ceiba.adn.estacionamiento.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.adn.estacionamiento.domain.repository.ParkingRepository;
import com.ceiba.adn.estacionamiento.domain.services.CreateTicketService;
import com.ceiba.adn.estacionamiento.domain.services.FindActiveTicketsService;
import com.ceiba.adn.estacionamiento.domain.services.UpdateTicketService;


@Configuration
public class BeanService {

	@Bean
	public CreateTicketService servicioCrearUsuario(ParkingRepository parkingRepository) {
		return new CreateTicketService(parkingRepository);
	}

	@Bean
	public UpdateTicketService servicioEliminarUsuario(ParkingRepository parkingRepository)  {
		return new UpdateTicketService(parkingRepository);
	}
	
	@Bean
	public FindActiveTicketsService servicioActualizarUsuario(ParkingRepository parkingRepository)  {
		return new FindActiveTicketsService(parkingRepository);
	}

}
