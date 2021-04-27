package com.demo.merchantapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:db/connection.properties")
@ComponentScan("com.demo.merchantapp")
public class SpringApplicationConfig {

	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;
	@Value("${db.dialect}")
	private String dialect;
	@Value("${db.hbm2ddl}")
	private String hbm2ddl;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public SessionFactory sessionFactory() {
		return new LocalSessionFactoryBuilder(dataSource()).scanPackages("com.demo.merchantapp.dao")
				.addProperties(hibernateProperties()).buildSessionFactory();
	}

	@Bean
	@Profile("prod")
	public DataSource dataSource() {
		try {
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setDriverClassName(driverClassName);
			hikariConfig.setJdbcUrl(url);
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);
			return new HikariDataSource(hikariConfig);
		} catch (Exception e) {
			return null;
		}
	}

	@Bean
	@Profile("prod")
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", dialect);
		hibernateProp.put("hibernate.hbm2ddl.auto", hbm2ddl);
		return hibernateProp;
	}

}
