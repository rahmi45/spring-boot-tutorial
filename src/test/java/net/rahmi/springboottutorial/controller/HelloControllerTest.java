package net.rahmi.springboottutorial.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
public class HelloControllerTest 
{

	@Autowired
	private MockMvc mockMvc;

	@Test
	void hello() throws Exception 
	{
	    mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
	        .andDo(print())
	        .andExpect(status().isOk())
	        .andExpect(content().string("Hello Rachid !"));
	}
}
