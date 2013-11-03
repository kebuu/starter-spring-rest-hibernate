package com.cta.dao;

import java.util.List;

import com.cta.model.Fake;
import com.google.common.base.Optional;

public interface FakeDao {

	List<Fake> searchFakeByExample(Optional<Fake> example);
}
