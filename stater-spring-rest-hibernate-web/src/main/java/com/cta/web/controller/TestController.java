package com.cta.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cta.misc.i18n.ImprovedMessageSource;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	protected ImprovedMessageSource messageSource;
	
	@RequestMapping(value="/echo", method=RequestMethod.GET)
	@ResponseBody
	public String echo() {
		return "I'm alive !! ALIVE !!";
	}
	
	@RequestMapping(value="/echo/localized", method=RequestMethod.GET)
	@ResponseBody
	public String localizedEcho() {
		return messageSource.getMessage("test.echo", null);
	}
	
	@RequestMapping(value="/exception", method=RequestMethod.GET)
	@ResponseBody
	public String exception() {
		throw new RuntimeException("Testing exception");
	}
}
