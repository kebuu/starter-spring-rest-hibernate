package com.cta.misc.utils;

import com.cta.exception.AppException;

public abstract class MyExceptionUtils {

	public static AppException unhandle(Throwable throwable) {
		return new AppException(throwable);
	}
	
	public static void throwIfNull(Object object, AppException exception) {
		throwIfTrue(object == null, exception);
	}
	
	public static void throwIfTrue(boolean condition, AppException exception) {
		if(condition) {
			throw exception;
		}
	}
}
