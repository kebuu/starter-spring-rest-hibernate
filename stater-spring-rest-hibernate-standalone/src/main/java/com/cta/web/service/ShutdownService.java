package com.cta.web.service;

import com.cta.web.EmbededServer;

public interface ShutdownService {

	void shutdown();
	
	void setServer(EmbededServer server);
}
