package com.cta.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cta.model.Fake;
import com.cta.service.FakeService;

@Controller
@RequestMapping("/fake")
public class FakeController {

	@Autowired
	protected FakeService fakeService;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Fake> list() {
		return fakeService.searchFake(null, null);
	}
}
