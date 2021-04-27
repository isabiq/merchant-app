package com.demo.merchantapp.business.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@Profile("test")
public class SpringTestConfiguration {

	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("org.h2.Driver");
		hikariConfig.setJdbcUrl("jdbc:h2:mem:testdb");
		hikariConfig.setUsername("sa");
		hikariConfig.setPassword("");
		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
		DatabasePopulatorUtils.execute(populateDatabase(), hikariDataSource);
		return hikariDataSource;
	}

	private DatabasePopulator populateDatabase() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("db/merchant-app-schema.sql"));
		populator.addScript(new ClassPathResource("db/merchant-app-test-data.sql"));
		return populator;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		hibernateProp.put("hibernate.hbm2ddl.auto", "none");
		return hibernateProp;
	}
}
