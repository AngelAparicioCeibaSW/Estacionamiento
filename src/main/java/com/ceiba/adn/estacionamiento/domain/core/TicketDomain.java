package com.ceiba.adn.estacionamiento.domain.core;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDomain {
	
	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private int displacement;
	private String typeVehicle;
	
	
}
