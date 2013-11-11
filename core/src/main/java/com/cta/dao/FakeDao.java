package com.cta.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cta.model.Fake;
import com.google.common.base.Optional;

@Transactional
public interface FakeDao {

	List<Fake> searchFakeByExample(Optional<Fake> example);
}
