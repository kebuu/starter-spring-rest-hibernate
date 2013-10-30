package com.cta.service.threadlocal;

public interface ThreadLocalService<T> {
	
	T getData();

	void setData(T data);

	void removeData();

}