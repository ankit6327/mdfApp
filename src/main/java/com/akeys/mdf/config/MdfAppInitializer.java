package com.akeys.mdf.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * The Class MdfAppInitializer.
 *
 * @author Ankit Sood May 2, 2017
 */
public class MdfAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	 
 
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { MdfAppConfiguration.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
 
}
