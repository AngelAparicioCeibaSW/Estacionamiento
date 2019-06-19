package com.ceiba.adn.estacionamiento.application.query;

import java.util.Date;

public class TicketActiveQuery {
	
	private String licensePlate;
	private String entry;
	private String typeVehicle;
	
	public TicketActiveQuery(String licensePlate,Date entry,String typeVehicle) {
		this.entry=  String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM", entry);
		this.licensePlate = licensePlate;
		this.typeVehicle = typeVehicle;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	
	

}
