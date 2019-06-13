package com.ceiba.adn.estacionamiento.domain.entity;

import java.util.Date;

public class Ticket {
	
	private static final String LICENSEPLATE_IS_EMPTY = "Se debe ingresar la placa";
	private static final String TYPE_VEHICLE_IS_EMPTY = "Se debe ingresar el tipo";
	private static final String CURRENT_DATE_IS_EMPTY = "Se debe registrar la fecha actual";
	private static final String INVALID_TYPE_VEHICLE = "Se debe ingresar un tipo valido de vehiculo";
	private static final String DISPLACEMENT_MOTORCYCLE_IS_EMPTY = "Se debe ingresar el cilindraje para las motos";
	private static final String MOTO  = "MOTO";
	
	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private String displacement;
	private String typeVehicle;
	
	public Ticket(String licensePlate,String displacement,String typeVehicle,Date entry) {
		ArgumentValidator.validateRequired(licensePlate, LICENSEPLATE_IS_EMPTY);
		ArgumentValidator.validateRequired(typeVehicle, TYPE_VEHICLE_IS_EMPTY);
		ArgumentValidator.validateDateRequired(entry, CURRENT_DATE_IS_EMPTY);
		ArgumentValidator.validateTypeVehicle(typeVehicle, INVALID_TYPE_VEHICLE);
		if(typeVehicle.equalsIgnoreCase(MOTO)) {
			ArgumentValidator.validateRequired(displacement, DISPLACEMENT_MOTORCYCLE_IS_EMPTY);
			this.displacement = displacement;
		}
		this.entry = entry;
		this.licensePlate = licensePlate;
		this.status = true;
		this.typeVehicle = typeVehicle;
	}
	
	public Ticket() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Date getEntry() {
		return entry;
	}

	public void setEntry(Date entry) {
		this.entry = entry;
	}

	public Date getExit() {
		return exit;
	}

	public void setExit(Date exit) {
		this.exit = exit;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	
	
	
	
}
