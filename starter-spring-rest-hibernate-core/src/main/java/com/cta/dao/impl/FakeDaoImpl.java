package com.cta.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;

import com.cta.dao.AbstractDao;
import com.cta.dao.FakeDao;
import com.cta.misc.utils.CriteriaUtils;
import com.cta.model.Fake;
import com.google.common.base.Optional;

@Service
public class FakeDaoImpl extends AbstractDao implements FakeDao {

	@Override
	public List<Fake> searchFakeByExample(Optional<Fake> example) {
		Criteria criteria = createQuery(Fake.class);
		
		if (example.isPresent()) {
			criteria.add(Example.create(example.get()));
		}
		
		return CriteriaUtils.list(criteria, Fake.class);
	}
}
