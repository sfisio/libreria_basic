package com.library;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LibraryApplication.class);
	}

//	@Override
//	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
//		DispatcherServlet ds = new DispatcherServlet(servletAppContext);
//		ds.setThrowExceptionIfNoHandlerFound(true);
//		return ds;
//	}

}
