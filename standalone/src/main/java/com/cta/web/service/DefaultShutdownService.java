package com.cta.web.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import com.cta.web.EmbededServer;

@Slf4j
@Setter
public class DefaultShutdownService implements ShutdownService {

	protected EmbededServer server;
	
	@Override
	public void shutdown() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(server != null) {
					log.info("Shutting down server");
					server.stop();
				}
			}
		}).start();
	}
}
