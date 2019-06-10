package com.ceiba.adn.estacionamiento.domain.core;

import java.util.Date;
import lombok.Data;

@Data
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
