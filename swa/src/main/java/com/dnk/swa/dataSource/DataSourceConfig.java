package com.dnk.swa.dataSource;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource.hikari.mariadb")
	public DataSource mariadbDatasource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.hikari.postgre")
	public DataSource postgreDatasource() {
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}

}
