package com.kirago.chapter02.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName Beanconfig
 * @Description TODO
 * @Author kirago
 * @Date 2018/11/9 10:27
 * @Version 1.0
 **/
@Configuration
@EnableTransactionManagement
public class Beanconfig {

	@Bean(name = "oneDataSource")
	@Qualifier("oneDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.one")
	public DataSource oneDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "twoDataSource")
	@Qualifier("twoDataSource")
	@ConfigurationProperties(prefix = "spring.datasouce.twe")
	public DataSource twoDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "oneJdbcTemplate")
	public JdbcTemplate oneJdbcTemplate(@Qualifier("oneDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "twoJdbcTemplate")
	public JdbcTemplate twoJdbcTemplate(@Qualifier("twoDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
