package com.cta.misc.threadlocal;

public interface ThreadLocalService<T> {
	
	T getData();

	void setData(T data);

	void removeData();

}