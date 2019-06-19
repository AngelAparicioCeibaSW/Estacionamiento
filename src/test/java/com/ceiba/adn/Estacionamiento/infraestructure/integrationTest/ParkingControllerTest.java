package com.ceiba.adn.estacionamiento.infraestructure.integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.adn.estacionamiento.ApplicationMock;
import com.ceiba.adn.estacionamiento.EstacionamientoApplication;
import com.ceiba.adn.estacionamiento.application.command.TicketCommand;
import com.ceiba.adn.estacionamiento.application.common.CommandResponse;
import com.ceiba.adn.estacionamiento.infraestructure.integration.testDatabuilder.TicketCommandDataBuilder;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = EstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ParkingControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mvc;
	private static final String URL_TICKETS = "/api/ticket/";
	private static final String LICENSEPLATE_CAR = "URG-586";
	private static final String LICENSEPLATE_MOTORCYCLE = "URG-589";
	private static final String MOTO = "MOTO";
	private static final String CARRO = "CARRO";
	private static final String DISPLACEMENT = "400";
	private static final float  PRICE_CAR= 1000;
	private static final float  PRICE_MOTORCYCLE= 500;
	

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void getActiveTickets() throws Exception {
		this.mvc.perform(get(URL_TICKETS).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

	@Test
	public void registerIncometCar() throws Exception {
		TicketCommandDataBuilder ticketBuilder = new TicketCommandDataBuilder().whitLicensePlate(LICENSEPLATE_CAR).whitTypeVehicle(CARRO);
		TicketCommand ticket = ticketBuilder.build();
		JSONObject jsonTicketComman = new JSONObject(ticket);
		CommandResponse<TicketCommand> commandResponse = new CommandResponse<>(ticket);
		JSONObject jsonTicketCommanResponse = new JSONObject(commandResponse);
		mvc.perform(post(URL_TICKETS).content(jsonTicketComman.toString()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().json(jsonTicketCommanResponse.toString()));
	}
	
	@Test
	public void registerIncomeMotorcycle() throws Exception {
		TicketCommandDataBuilder ticketBuilder = new TicketCommandDataBuilder().whitLicensePlate(LICENSEPLATE_MOTORCYCLE).whitTypeVehicle(MOTO).whitDisplacement(DISPLACEMENT);
		TicketCommand ticket = ticketBuilder.build();
		JSONObject jsonTicketComman = new JSONObject(ticket);
		CommandResponse<TicketCommand> commandResponse = new CommandResponse<>(ticket);
		JSONObject jsonTicketCommanResponse = new JSONObject(commandResponse);
		mvc.perform(post(URL_TICKETS).content(jsonTicketComman.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(jsonTicketCommanResponse.toString()));
	}

	@Test
	public void registerExitMotorcycle() throws Exception {
		TicketCommandDataBuilder ticketBuilder = new TicketCommandDataBuilder().whitLicensePlate(LICENSEPLATE_MOTORCYCLE);
		TicketCommand ticket = ticketBuilder.build();
		JSONObject jsonTicketComman = new JSONObject(ticket);
		CommandResponse<Float> responseExit = new CommandResponse<>(PRICE_MOTORCYCLE);
		JSONObject responseCommand = new JSONObject(responseExit);
		mvc.perform(put(URL_TICKETS).content(jsonTicketComman.toString()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect((content().json(responseCommand.toString())));
		
	}

	@Test
	public void registerExitCar() throws Exception {
		TicketCommandDataBuilder ticketBuilder = new TicketCommandDataBuilder().whitLicensePlate(LICENSEPLATE_CAR);
		TicketCommand ticket = ticketBuilder.build();
		JSONObject jsonTicketComman = new JSONObject(ticket);
		CommandResponse<Float> responseExit = new CommandResponse<>(PRICE_CAR);
		JSONObject responseCommand = new JSONObject(responseExit);
		mvc.perform(put(URL_TICKETS).content(jsonTicketComman.toString()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect((content().json(responseCommand.toString())));
	}

}
