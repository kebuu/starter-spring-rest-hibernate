package com.cta.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cta.dao.FakeDao;
import com.cta.model.Fake;
import com.cta.service.FakeService;
import com.google.common.base.Optional;

@Service
public class FakeServiceImpl implements FakeService {

	@Autowired
	private FakeDao fakeDao;
	
	@Override
	public List<Fake> searchFake(String string, Date date) {
		Fake fakeExample = new Fake();
		fakeExample.setSomeString(string);
		fakeExample.setSomeDate(date);
		return fakeDao.searchFakeByExample(Optional.of(fakeExample));
	}
}
