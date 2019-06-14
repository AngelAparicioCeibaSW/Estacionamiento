package com.ceiba.adn.estacionamiento.domain.testDataBuilder;

import java.util.Date;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;

public class TicketTestDatabuilder {

	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private String displacement;
	private String typeVehicle;

	public TicketTestDatabuilder() {
	}

	public TicketTestDatabuilder whitId(long id) {
		this.id = id;
		return this;
	}

	public TicketTestDatabuilder whitLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;
	}

	public TicketTestDatabuilder whitEntry(Date entry) {
		this.entry = entry;
		return this;
	}

	public TicketTestDatabuilder whitExit(Date exit) {
		this.exit = exit;
		return this;
	}

	public TicketTestDatabuilder whitPrice(float price) {
		this.price = price;
		return this;
	}

	public TicketTestDatabuilder whitStatus(boolean status) {
		this.status = status;
		return this;
	}

	public TicketTestDatabuilder whitDisplacement(String displacement) {
		this.displacement = displacement;
		return this;
	}

	public TicketTestDatabuilder whitTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}

	public Ticket build() {
		Ticket ticket = new Ticket();
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
