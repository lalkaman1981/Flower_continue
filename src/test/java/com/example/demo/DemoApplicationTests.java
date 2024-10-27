package com.example.demo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.delivery.DHLDeliveryStrategy;
import com.example.demo.delivery.PostDeliveryStrategy;
import com.example.demo.flower.FlowerColor;
import com.example.demo.payment.CreditCardPaymentStrategy;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testListFlowers() throws Exception {
		mockMvc.perform(get("/order"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].items", hasSize(3)))
				.andExpect(jsonPath("$[0].items[0].price", is(10.0)))
				.andExpect(jsonPath("$[0].items[0].color", is(FlowerColor.BLUE.name())))
				.andExpect(jsonPath("$[0].delivery", is(DHLDeliveryStrategy.class.getSimpleName())))
				.andExpect(jsonPath("$[0].payment", is(CreditCardPaymentStrategy.class.getSimpleName())));
	}

	@Test
	void testPaymentEndpoint() throws Exception {
		mockMvc.perform(get("/payment"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.class", is(CreditCardPaymentStrategy.class.getSimpleName())));
	}

	@Test
	void testDeliveryEndpoint() throws Exception {
		mockMvc.perform(get("/delivery"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.class", is(PostDeliveryStrategy.class.getSimpleName())));
	}
}
