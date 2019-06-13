package com.ceiba.adn.estacionamiento.infraestructure.persist.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ticket")
public class TicketEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
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
	private String displacement;
	
	@Column(name = "type_vehicle", nullable = true)
	private String typeVehicle;
	
	

}
