package com.ceiba.adn.estacionamiento.infraestructure.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.ceiba.adn.estacionamiento.application.domain.*;
import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;
import com.ceiba.adn.estacionamiento.domain.services.ParkingService;

@RestController
@RequestMapping("/api/ticket")
@Api(tags = "ticket")
public class ParkingController {
	
	@Autowired
	private ParkingService service;

	public ParkingService getService() {
		return service;
	}
	
	@PostMapping("/saveTicket")
	@ApiOperation(value = "Registrar ticket", notes = "Registra un nuevo ticket")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Ticket registrado correctamente"),
			@ApiResponse(code = 404, message = "no fue posible registrar el ticket") })
	public ResponseEntity<TicketDomain> post(@RequestBody TicketApplication ticket) {
		return new ResponseEntity<>(service.registerIncome(ticket),HttpStatus.CREATED);
	}
	
	@GetMapping("/activeTickets")
	@ApiOperation(value = "Listar tickets activos", notes = "Lista todos los tickets que no tienen fecha de salida ni precio, o sea, "
			+ "tickets de vehículos que aún estan en el parqueadero")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Tickets activos listados correctamente"),
			@ApiResponse(code = 204, message = "No hay tickets activos") })
	public ResponseEntity<List<TicketDomain>> getActiveTickets() {
		List<TicketDomain> tickets = service.findActiveTickets();
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}
	

}
