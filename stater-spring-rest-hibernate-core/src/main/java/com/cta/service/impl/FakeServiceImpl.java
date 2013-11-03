package com.cta.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cta.model.Fake;
import com.cta.service.FakeService;

@Service
public class FakeServiceImpl implements FakeService {

	@Override
	public List<Fake> searchFake(String string, Date date) {
		return null;
	}
}
