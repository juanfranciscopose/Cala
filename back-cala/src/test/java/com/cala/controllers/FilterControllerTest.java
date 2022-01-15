package com.cala.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cala.controller.filters.FilterController;
import com.cala.model.dto.filters.FilterDto;
import com.cala.service.filters.I_FilterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(FilterController.class)
class FilterControllerTest {
	
	@Autowired
    private MockMvc mvc;
    
    @MockBean
    private I_FilterService filterService;
	
	@Test
	void testCreateFilter() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/filter/gender/create")
				.content(asJsonString(new FilterDto(null, "fem", true)));
		mvc.perform(request).andExpect(status().isCreated());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}

}
