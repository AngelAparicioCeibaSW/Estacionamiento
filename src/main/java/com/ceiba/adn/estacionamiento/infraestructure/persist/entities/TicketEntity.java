package com.ceiba.adn.estacionamiento.infraestructure.persist.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import lombok.Data;


@Data
@Entity
@Table(name = "ticket")
public class TicketEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "license_plate", nullable = false)
	private String licensePlate;
	
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "entry", nullable = false)
	private Date entry;
	
	@javax.persistence.Temporal(TemporalType.TIMESTAMP)
	@Column(name = "exit", nullable = true)
	private Date exit;
	
	@Column(name = "price", nullable = true)
	private float price;
	
	@Column(name = "status", nullable = false)
	private boolean status;
	
	@Column(name = "displacement", nullable = true)
	private int displacement;
	
	@Column(name = "type_vehicle", nullable = true)
	private String typeVehicle;
	
	

}
