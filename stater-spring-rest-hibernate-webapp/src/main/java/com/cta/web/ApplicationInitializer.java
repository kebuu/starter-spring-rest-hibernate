package com.cta.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		// Configure spring security
		WebConfigurerHelper.configureSpringSecurityFilter(servletContext);
		
		// Configure spring web context
		XmlWebApplicationContext webApplicationContext = WebConfigurerHelper.configureSpringContext(servletContext);
		
		// Create dispatcher servlet
		DispatcherServlet dispatcherServlet = WebConfigurerHelper.createDispatcherServlet(webApplicationContext);

		// Use dispatcher servlet in servlet context
		servletContext.addListener(new ContextLoaderListener(webApplicationContext));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}
}
