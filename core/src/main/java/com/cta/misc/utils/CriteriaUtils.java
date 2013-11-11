package com.cta.misc.utils;

import java.util.List;

import org.hibernate.Criteria;

public abstract class CriteriaUtils {

	@SuppressWarnings("unchecked")
	public static <T> List<T> list(Criteria criteria, Class<T> clazz) {
		return criteria.list();
	}
}
