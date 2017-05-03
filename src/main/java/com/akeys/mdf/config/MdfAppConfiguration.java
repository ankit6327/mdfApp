package com.akeys.mdf.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * The Class MdfAppConfiguration.
 *
 * @author Ankit Sood May 2, 2017
 */
@Configuration
@PropertySource(value = { "classpath:application.properties" })
@EnableCaching
@EnableWebMvc
@Import({ PersistenceConfig.class })
@ComponentScan(basePackages = "com.akeys.mdf")
public class MdfAppConfiguration {

    @Bean
    public CacheManager cacheManager() {
	return new ConcurrentMapCacheManager();
    }

}