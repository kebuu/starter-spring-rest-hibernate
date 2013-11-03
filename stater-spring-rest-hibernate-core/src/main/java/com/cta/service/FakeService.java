package com.cta.service;

import java.util.Date;
import java.util.List;

import com.cta.model.Fake;

public interface FakeService {

	List<Fake> searchFake(String string, Date date);
}
