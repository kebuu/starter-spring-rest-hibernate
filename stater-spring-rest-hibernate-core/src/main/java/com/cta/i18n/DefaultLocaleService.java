package com.cta.i18n;

import java.util.Locale;

import com.cta.service.threadlocal.AbstractThreadLocalService;

public class DefaultLocaleService extends AbstractThreadLocalService<Locale> implements LocaleService {

	@Override
	public Locale getLocale() {
		return getData();
	}
}
