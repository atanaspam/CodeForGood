package jpm.codeforgood.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

@PropertySource("classpath:jdbc.properties")
public class SpringDataConfig implements TransactionManagementConfigurer {

	@Value("${jdbc.driverClassName}")
	private String driverClassName;
	@Value("${jdbc.url}")
	private String dbUrl;
	@Value("${jdbc.username}")
	private String dbUserName;
	@Value("${jdbc.password}")
	private String dbPassword;

	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager();
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUserName);
		dataSource.setPassword(dbPassword);
		dataSource.setMaxActive(10);
		dataSource.setMaxIdle(10);
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
