package com.ceiba.adn.estacionamiento.domain.core.testDataBuilder;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.adn.estacionamiento.domain.core.TicketDomain;

public class TicketDomainTestDatabuilder {

	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private int displacement;
	private String typeVehicle;
	
	public TicketDomainTestDatabuilder() {
		this.id = (long) 10 ;
		this.licensePlate = "URG-585";
		this.entry = Calendar.getInstance().getTime();
		this.status = false;
		this.displacement = 300;
		this.typeVehicle ="MOTO";
	}

	public TicketDomainTestDatabuilder whitId(long id) {
		this.id = id;
		return this;
	}

	public TicketDomainTestDatabuilder whitLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;
	}

	public TicketDomainTestDatabuilder whitEntry(Date entry) {
		this.entry = entry;
		return this;
	}

	public TicketDomainTestDatabuilder whitExit(Date exit) {
		this.exit = exit;
		return this;
	}

	public TicketDomainTestDatabuilder whitPrice(float price) {
		this.price = price;
		return this;
	}

	public TicketDomainTestDatabuilder whitStatus(boolean status) {
		this.status = status;
		return this;
	}

	public TicketDomainTestDatabuilder whitDisplacement(int displacement) {
		this.displacement = displacement;
		return this;
	}

	public TicketDomainTestDatabuilder whitLicenseTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}

	public TicketDomain build() {
		return new TicketDomain(id, licensePlate, entry, exit, price, status, displacement, typeVehicle);
	}
}
