package com.spring.web.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author Nagendra
 * This is equivalent to web.xml
 * 
 */
public class ApplicationBootstrapConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

	//This will create spring root container //context loader listener
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	//This will create spring root container //dispatcher servlet
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebApplicationIntializer.class };
	}

	 /* <servlet-mapping>
		<servlet-name>profile</servlet-name>
		<url-pattern>/</url-pattern>
		</servlet-mapping>
	*/@Override
	protected String[] getServletMappings() {
		 return new String[] { "/" };
	}

}
