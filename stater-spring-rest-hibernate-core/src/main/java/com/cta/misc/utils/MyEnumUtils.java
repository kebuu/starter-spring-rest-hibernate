package com.cta.misc.utils;

import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Optional;

public abstract class MyEnumUtils {

	public static <E extends Enum<E>> E getEnum(Class<E> enumClass, String enumName, E defaultValue) {
        E result = EnumUtils.getEnum(enumClass, StringUtils.upperCase(enumName));
        
        if(result == null) {
        	result = defaultValue;
        }
        return result;
    }
	
	public static <E extends Enum<E>> Optional<E> getEnum(Class<E> enumClass, String enumName) {
		E result = getEnum(enumClass, enumName, null);
		return Optional.fromNullable(result);
	}
}
