package com.ceiba.adn.estacionamiento.domain.entity;

import java.util.Date;

public class Ticket {
	
	private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
	private static final String SE_DEBE_INGRESAR_EL_TIPO = "Se debe ingresar el tipo";
	private static final String SE_DEBE_REGISTRAR_LA_FECHA_ACTUAL = "Se debe registrar la fecha actual";
	private static final String SE_DEBE_INGRESAR_UN_TIPO_VALIDO_DE_VEHICULO = "Se debe ingresar un tipo valido de vehiculo";
	private static final String SE_DEBE_INGRESAR_EL_CILINDARJE_PARA_LAS_MOTOS = "Se debe ingresar el cilindraje para las motos";
	
	private Long id;
	private String licensePlate;
	private Date entry;
	private Date exit;
	private float price;
	private boolean status;
	private String displacement;
	private String typeVehicle;
	
	public Ticket(String licensePlate,String displacement,String typeVehicle,Date entry) {
		ArgumentValidator.validateRequired(licensePlate, SE_DEBE_INGRESAR_LA_PLACA);
		ArgumentValidator.validateRequired(typeVehicle, SE_DEBE_INGRESAR_EL_TIPO);
		ArgumentValidator.validateDateRequired(entry, SE_DEBE_REGISTRAR_LA_FECHA_ACTUAL);
		ArgumentValidator.validateTypeVehicle(typeVehicle, SE_DEBE_INGRESAR_UN_TIPO_VALIDO_DE_VEHICULO);
		if(typeVehicle.equalsIgnoreCase("MOTO")) {
			ArgumentValidator.validateRequired(displacement, SE_DEBE_INGRESAR_EL_CILINDARJE_PARA_LAS_MOTOS);
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
