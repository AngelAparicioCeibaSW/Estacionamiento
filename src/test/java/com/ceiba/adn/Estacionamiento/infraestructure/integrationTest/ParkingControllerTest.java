package com.ceiba.adn.estacionamiento.infraestructure.integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@SpringBootTest(classes = EstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ParkingControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mvc;
	private static final String URL_TICKETS = "/api/ticket/";

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void getActiveTickets() throws Exception {
		this.mvc.perform(get(URL_TICKETS).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void registerIncometCarro() throws Exception {
		mvc.perform(post(URL_TICKETS).content("{\r\n" + 
				"	\"licensePlate\" : \"URG-585\",\r\n" + 
				"	\"displacement\" : \"\",\r\n" + 
				"	\"typeVehicle\" : \"CARRO\"\r\n" + 
				" }").contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	public void registerIncomeMoto() throws Exception {
		mvc.perform(post(URL_TICKETS).content("{\r\n" + 
				"	\"licensePlate\" : \"URG-586\",\r\n" + 
				"	\"displacement\" : \"500\",\r\n" + 
				"	\"typeVehicle\" : \"MOTO\"\r\n" + 
				" }").contentType(MediaType.APPLICATION_JSON)
				).andExpect(status().isOk());
	}
	
	@Test
	public void registerExit() throws Exception {
		mvc.perform(put(URL_TICKETS).content("URG-585")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	

}
