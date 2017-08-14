package com.springboot.exploration.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring boot initializer class.
 * 
 * @author Naveen Tyagi
 *
 */
@SpringBootApplication(scanBasePackages = "com.springboot.exploration")
@EnableTransactionManagement
@EntityScan(basePackages = "com.springboot.exploration.model")
public class ApplicationInitializing extends SpringBootServletInitializer {

	@Autowired
	private Environment environment;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationInitializing.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationInitializing.class, args);
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.springboot.exploration.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		return dataSource;
	}

	public Properties hibernateProperties() {

		Properties hibernateProperties = new Properties();

		hibernateProperties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		hibernateProperties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));

		return hibernateProperties;
	}
}