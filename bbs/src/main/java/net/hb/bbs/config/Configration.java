package net.hb.bbs.config;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Configration {
	
	@Bean(destroyMethod = "cleanup")
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		basicDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		basicDataSource.setUsername("system");
		basicDataSource.setPassword("oracle");
		basicDataSource.setMinIdle(50);
		basicDataSource.setMaxIdle(50);
		basicDataSource.setMaxActive(100);
		return basicDataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(BasicDataSource dataSource) {		
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public SqlSessionFactoryBean factoryBean(BasicDataSource dataSource) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();		
		factoryBean.setConfigLocation(null);
	}
	
	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate sqlSession(SqlSessionFactoryBean factoryBean) {
		SqlSessionTemplate sqlSession = new SqlSessionTemplate();
	}
