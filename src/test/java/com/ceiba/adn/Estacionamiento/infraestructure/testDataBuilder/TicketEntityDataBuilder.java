package com.ceiba.adn.estacionamiento.infraestructure.testDataBuilder;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;

public class TicketEntityDataBuilder {
	
	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private String displacement;
	private String typeVehicle;

	public TicketEntityDataBuilder() {
		this.id = (long) 10;
		this.licensePlate = "URG-585";
		this.entry = Calendar.getInstance().getTime();
		this.status = false;
		this.displacement = "300";
		this.typeVehicle = "MOTO";
	}

	public TicketEntityDataBuilder whitId(long id) {
		this.id = id;
		return this;
	}

	public TicketEntityDataBuilder whitLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;
	}

	public TicketEntityDataBuilder whitEntry(Date entry) {
		this.entry = entry;
		return this;
	}

	public TicketEntityDataBuilder whitExit(Date exit) {
		this.exit = exit;
		return this;
	}

	public TicketEntityDataBuilder whitPrice(float price) {
		this.price = price;
		return this;
	}

	public TicketEntityDataBuilder whitStatus(boolean status) {
		this.status = status;
		return this;
	}

	public TicketEntityDataBuilder whitDisplacement(String displacement) {
		this.displacement = displacement;
		return this;
	}

	public TicketEntityDataBuilder whitTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}

	public TicketEntity build() {
		TicketEntity ticket = new TicketEntity();
		ticket.setId(this.id);
		ticket.setDisplacement(this.displacement);
		ticket.setEntry(this.entry);
		ticket.setExit(this.exit);
		ticket.setLicensePlate(this.licensePlate);
		ticket.setPrice(this.price);
		ticket.setStatus(this.status);
		ticket.setTypeVehicle(this.typeVehicle);
		return ticket;
	}

}
