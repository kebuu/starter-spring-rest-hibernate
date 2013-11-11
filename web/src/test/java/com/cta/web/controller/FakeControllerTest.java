package com.cta.web.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.cta.model.Fake;
import com.fasterxml.jackson.core.type.TypeReference;


public class FakeControllerTest extends BaseSpringWebTest {
	
    @Test
    public void listFake() throws Exception {
    	
    	//CREATE
        String responseAsString = this.mockMvc.perform(get("/fake").accept(MediaType.APPLICATION_JSON))
          .andReturn().getResponse().getContentAsString();
          
        List<Fake> fakes = objectMapper.readValue(responseAsString, new TypeReference<List<Fake>>(){});
        assertEquals(5, fakes.size());
    }
}
