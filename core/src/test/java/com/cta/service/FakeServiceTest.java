package com.cta.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.cta.dao.FakeDao;
import com.cta.model.Fake;
import com.cta.service.impl.FakeServiceImpl;
import com.google.common.base.Optional;

@RunWith(value=MockitoJUnitRunner.class)
public class FakeServiceTest {

	@InjectMocks
	private FakeServiceImpl fakeService;
	
	@Mock
	private FakeDao fakeDao;
	
	@Before
	@SuppressWarnings("unchecked")
	public void setUpFakeServiceTest() {
		when(fakeDao.searchFakeByExample(any(Optional.class))).thenReturn(new ArrayList<Fake>());
	}
	
    @Test
    public void testSearchFake() {
    	assertEquals(0, fakeService.searchFake("string", new Date()).size());
    }
}
