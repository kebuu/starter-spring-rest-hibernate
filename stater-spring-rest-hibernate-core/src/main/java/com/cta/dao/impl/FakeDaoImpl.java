package com.cta.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cta.dao.AbstractDao;
import com.cta.dao.FakeDao;
import com.cta.model.Fake;
import com.google.common.base.Optional;

@Service
public class FakeDaoImpl extends AbstractDao implements FakeDao {

	@Override
	public List<Fake> searchFakeByExample(Optional<Fake> example) {
		return null;
	}
}
