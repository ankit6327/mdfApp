package com.akeys.mdf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The Class MdfAppConfiguration.
 *
 * @author Ankit Sood May 2, 2017
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.akeys.mdf")
public class MdfAppConfiguration {

}