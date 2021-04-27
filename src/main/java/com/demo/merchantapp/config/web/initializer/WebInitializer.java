package com.demo.merchantapp.config.web.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.demo.merchantapp.config.SpringApplicationConfig;

public class WebInitializer implements WebApplicationInitializer {

	private static final Logger LOGGER = LoggerFactory.getLogger(WebInitializer.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOGGER.info("Start spring application context");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringApplicationConfig.class);
		servletContext.addListener(new ContextLoaderListener(context));
		servletContext.setInitParameter("spring.profiles.active", "prod");
	}

}
