package com.akeys.mdf.config;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * The Class PersistenceConfig.
 *
 * @author Ankit
 * @timeStamp May 3, 2017 11:35:16 PM
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.akeys.bankapp.model", "com.akeys.bankapp.dao" })
public class PersistenceConfig {

    @Autowired
    private Environment env;

    /**
     * Data source.
     *
     * @return the data source
     */
    @Bean(destroyMethod = "close")
    DataSource dataSource() {
	HikariConfig dataSourceConfig = new HikariConfig();
	dataSourceConfig.setDriverClassName(env.getRequiredProperty("jdbc.driverClassName"));
	dataSourceConfig.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
	dataSourceConfig.setUsername(env.getRequiredProperty("jdbc.username"));
	dataSourceConfig.setPassword(env.getRequiredProperty("jdbc.password"));
	System.out.println("Done!");
	return new HikariDataSource(dataSourceConfig);
    }

    /**
     * Entity manager factory.
     *
     * @param dataSource the data source
     * @return the local container entity manager factory bean
     */
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	entityManagerFactoryBean.setDataSource(dataSource);
	entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	entityManagerFactoryBean.setPackagesToScan("com.akeys.bankapp.model");
	Properties jpaProperties = new Properties();
	jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
	jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
	jpaProperties.put("hibernate.enable_lazy_load_no_trans",
		env.getRequiredProperty("hibernate.enable_lazy_load_no_trans"));
	jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
	jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
	entityManagerFactoryBean.setJpaProperties(jpaProperties);
	return entityManagerFactoryBean;
    }

    /**
     * Transaction manager.
     *
     * @param entityManagerFactory the entity manager factory
     * @return the jpa transaction manager
     */
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(entityManagerFactory);
	return transactionManager;
    }
}
