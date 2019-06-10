package com.ceiba.adn.estacionamiento.infraestructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.ceiba.adn.estacionamiento.application.domain.*;
import com.ceiba.adn.estacionamiento.domain.services.ParkingService;




@RestController
@RequestMapping("/api/ticket")
@Api(tags = "ticket")
public class ParkingController {
	
	private ParkingService service;

	public ParkingService getService() {
		return service;
	}
	
	@PostMapping("/registrarTicket")
	@ApiOperation(value = "Registrar ticket", notes = "Registra un nuevo ticket")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ticket registrado correctamente"),
			@ApiResponse(code = 404, message = "no fue posible registrar el ticket") })
	public ResponseEntity<TicketApplication> post(@RequestBody TicketApplication ticket) {
		service.registerIncome(ticket);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

}
