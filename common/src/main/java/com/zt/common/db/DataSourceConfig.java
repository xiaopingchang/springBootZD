package com.zt.common.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
	
	@Bean(name = "x_master")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource master(){
		return DataSourceBuilder.create().build();
	}
	
	/*@Bean(name = "x_slave")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	public DataSource slave(){
		return DataSourceBuilder.create().build();
	}*/
}
