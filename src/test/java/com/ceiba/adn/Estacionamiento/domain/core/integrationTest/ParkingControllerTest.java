package com.ceiba.adn.estacionamiento.domain.core.integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.adn.estacionamiento.EstacionamientoApplication;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = EstacionamientoApplication.class)
@AutoConfigureMockMvc
public class ParkingControllerTest {

	private MockMvc mvc;
	
	@Test
	public void getActiveTickets() throws Exception {
		mvc.perform(get("/api/ticket/activeTickets")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful());
	}
}
