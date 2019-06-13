package com.ceiba.adn.estacionamiento.infraestructure.unitTest;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.ceiba.adn.estacionamiento.domain.entity.Ticket;
import com.ceiba.adn.estacionamiento.domain.testDataBuilder.TicketTestDatabuilder;
import com.ceiba.adn.estacionamiento.infraestructure.persist.entities.TicketEntity;
import com.ceiba.adn.estacionamiento.infraestructure.persist.mapper.TicketMapper;
import com.ceiba.adn.estacionamiento.infraestructure.testDataBuilder.TicketEntityDataBuilder;

public class TicketMapperTest {
	private TicketTestDatabuilder ticketBuilder;
	private TicketEntityDataBuilder ticketEntityBuilder;
	private Ticket ticket;
	private TicketEntity ticketEntity;
	private TicketMapper mapper;
	
	
	@Before
	public void setUp() {
		// arrange
		this.ticketBuilder = new TicketTestDatabuilder();
		this.ticketEntityBuilder = new TicketEntityDataBuilder();
		this.mapper = TicketMapper.getInstance();
	}
	
	
	/**
	 * 
	 * Test el cual verifica que mapper convierta un objeto domain en entity
	 */
	@Test
	public void mapperDomainToEntity() {
		// act
		this.ticket = this.ticketBuilder.build();
		this.ticketEntity = this.mapper.toEntity(ticket);
		//assert
		assertNotNull(ticketEntity);
	}
	
	
	/**
	 * 
	 * Test el cual verifica que mapper convierta un objeto  entity en domain
	 */
	@Test
	public void mapperEntityToDomain() {
		// act
		this.ticketEntity = this.ticketEntityBuilder.build();
		this.ticket = this.mapper.toDomain(this.ticketEntity);
		//assert
		assertNotNull(ticket);
	}
	
}
