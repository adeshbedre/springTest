package com.spring.test.springtest;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan( basePackages = {"com.spring.test.springtest"} )
public class Config {

	@Bean
	public Address getAddr() {
		Address address = new Address();
		address.setCity("some");
		return address;
	}
	
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //MySQL database we are using
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/springtest");//change url
        dataSource.setUsername("user");//change userid
        dataSource.setPassword("password");//change pwd
        
//        <!-- <property name="driverClassName" value="com.mysql.jdbc.Driver" />   -->
//        <!-- <property name="url" value="jdbc:mysql://localhost:3306/database" />   -->
//        <!-- <property name="username" value="user" />   -->
//        <!-- <property name="password" value="password" />   -->
//        <!-- </bean>   -->
        return dataSource;
    }
 
    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    
//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
//    {
//        HibernateTransactionManager htm = new HibernateTransactionManager();
//        htm.setSessionFactory(sessionFactory);
//        return htm;
//    }
//    
//    @Bean
//    @Autowired
//    public HibernateTemplate getHibernateTemplate(SessionFactory sessionFactory)
//    {
//        HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
//        return hibernateTemplate;
//    }
//        
//    @Bean
//    public AnnotationSessionFactoryBean getSessionFactory()
//    {
//        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
//        asfb.setDataSource(getDataSource());
//        asfb.setHibernateProperties(getHibernateProperties());        
//        asfb.setPackagesToScan(new String[]{"com.sivalabs"});
//        return asfb;
//    }
//
//    @Bean
//    public Properties getHibernateProperties()
//    {
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", hibernateDialect);
//        properties.put("hibernate.show_sql", hibernateShowSql);
//        properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
//        
//        return properties;
//    }
}
