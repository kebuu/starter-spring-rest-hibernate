package com.cta.misc.json;

import org.springframework.beans.factory.InitializingBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class CustomObjectMapper extends ObjectMapper implements InitializingBean {

	private static final long serialVersionUID = 1L;

	@Override
	public void afterPropertiesSet() throws Exception {
		this.registerModule(new JodaModule());
	}

}
