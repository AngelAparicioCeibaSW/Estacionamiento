package com.ceiba.adn.estacionamiento.domain.testdatabuilder;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;

public class TicketTestDatabuilder {

	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private int displacement;
	private String typeVehicle;
	
	public TicketTestDatabuilder() {
		this.id = (long) 10 ;
		this.licensePlate = "URG-585";
		this.entry = Calendar.getInstance().getTime();
		this.status = false;
		this.displacement = 300;
		this.typeVehicle ="MOTO";
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

	public TicketTestDatabuilder whitDisplacement(int displacement) {
		this.displacement = displacement;
		return this;
	}

	public TicketTestDatabuilder whitLicenseTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}

	//public Ticket build() {
	//	return new Ticket(id, licensePlate, entry, exit, price, status, displacement, typeVehicle);
	//}
}
