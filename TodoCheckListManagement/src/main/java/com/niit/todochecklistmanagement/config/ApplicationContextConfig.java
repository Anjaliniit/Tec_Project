package com.niit.todochecklistmanagement.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.niit.todochecklistmanagement.model.Todo;
	
	
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.niit")
@EnableWebMvc
public class ApplicationContextConfig {

		@Bean(name = "dataSource" )
		public DataSource getDataSource(){
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/project");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			return dataSource;
		}
		
		private Properties getHibernateProperties(){
			Properties properties = new Properties();
			properties.put("hibernate.show_sql","true");
			properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
			properties.put("hibernate.hbm2ddl.auto","update");
			return properties;
		}
		
		@Autowired
		@Bean(name = "sessionFactory" )
		public SessionFactory getSessionFactory(DataSource dataSource){
			LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
			sessionBuilder.addProperties(getHibernateProperties());
			sessionBuilder.addAnnotatedClass(Todo.class);
			return sessionBuilder.buildSessionFactory();
			
		}

		@Autowired
		@Bean(name = "transactionManager" )
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			return transactionManager;
		}

}
