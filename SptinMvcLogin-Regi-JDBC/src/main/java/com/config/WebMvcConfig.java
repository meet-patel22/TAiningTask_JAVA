package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.dao.UserDao;
import com.dao.UserDaoImpl;
@Configuration
@ComponentScan("com.controller")
public class WebMvcConfig 
{
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/");
		vr.setSuffix(".jsp");
		return vr;

	}
	
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/userdb");
		ds.setUsername("root");
		ds.setPassword("root@123");
		return ds;
	}
	
	@Bean
	public UserDao getUserDao()
	{
		return new UserDaoImpl(getDataSource());
		
	}
	
	
}
