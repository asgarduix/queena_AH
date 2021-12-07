package com.asi.huanan.service.connector;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
//@MapperScan("com.asi.service.mapper")

@Configuration
//@MapperScan("com.asi")
public class MyBatisConnector {

	private Logger log = LogManager.getLogger(MyBatisConnector.class);

	@Autowired
	private Environment env;

	@Autowired
	private DataSource dataSource;

//	/**
//	 * 使用 application.yml 或 application.properties 中的設定值 一般指定 DataSource Bean 的方法
//	 * <bean id="dataSource" class="org.apache.tomcat.jdbc.pool.DataSource">
//	 * <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
//	 * <property name="url" value=
//	 * "jdbc:mysql://127.0.0.1:3306/springboot_demo?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC"/>
//	 * <property name="username" value="springboot"/>
//	 * <property name="password" value="springboot"/> </bean>
//	 * 
//	 * @return org.apache.tomcat.jdbc.pool.DataSource 類別的物件;
//	 */
	@Bean(name = "datasource")
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().driverClassName(env.getProperty("spring.datasource.driver-class-name"))
				.url(env.getProperty("spring.datasource.url")).username(env.getProperty("spring.datasource.username"))
				.password(env.getProperty("spring.datasource.password")).build();
	}

//	/**
//	 * MyBatis Mapper XML 於 resources 下的存放路徑
//	 */
//	@Value("${mybatis.xml.path}")
//	private String mybatisXmlPath;

	/**
	 * 
	 */
	@Bean(name = "transaction")
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(this.dataSource);
	}

	/**
	 * 
	 */
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory createSqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(this.dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:" + "mapper" + "/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

}
