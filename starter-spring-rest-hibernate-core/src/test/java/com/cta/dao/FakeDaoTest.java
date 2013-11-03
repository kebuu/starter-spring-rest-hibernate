package com.cta.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cta.model.Fake;
import com.cta.test.BaseSpringTest;
import com.google.common.base.Optional;

public class FakeDaoTest extends BaseSpringTest {

	@Autowired
	protected FakeDao fakeDao;
	
	@Test
	@Transactional
	public void searchFake() {
		List<Fake> fakes = fakeDao.searchFakeByExample(Optional.<Fake>absent());
		assertEquals(5, fakes.size());
	}
} 
