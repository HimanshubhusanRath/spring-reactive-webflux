package com.hr.springbootwebflux.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hr.springbootwebflux.handler.CustomerHandler;
import com.hr.springbootwebflux.handler.CustomerStreamHandler;

@Configuration
public class RouterConfig {

	@Autowired
	private CustomerHandler customerHandler;
	
	@Autowired
	private CustomerStreamHandler customerStreamHandler;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction()
	{
		return RouterFunctions.route()
				.GET("/router/customers",customerHandler::getCustomers)
				.GET("/router/customerstream",customerStreamHandler::getCustomerStream)
				.GET("/router/findcustomer/{id}",customerHandler::findCustomer)
				.POST("/router/savecustomer",customerHandler::saveCustomer)
				.build();
	}
}
