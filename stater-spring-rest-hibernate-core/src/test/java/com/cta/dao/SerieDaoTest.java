package com.cta.dao;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cta.test.BaseSpringTest;

public class SerieDaoTest extends BaseSpringTest {

	@Autowired
	protected FakeDao fakeDao;
	
	@Test
	@Transactional
	public void searchFake() {
		
	}
} 
