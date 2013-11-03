package com.cta.misc.i18n.service;

import java.util.Locale;

import com.cta.misc.threadlocal.AbstractThreadLocalService;

public class DefaultLocaleService extends AbstractThreadLocalService<Locale> implements LocaleService {

	@Override
	public Locale getLocale() {
		return getData();
	}
}
