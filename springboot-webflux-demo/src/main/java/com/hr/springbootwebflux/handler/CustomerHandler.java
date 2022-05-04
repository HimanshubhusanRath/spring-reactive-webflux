package com.hr.springbootwebflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hr.springbootwebflux.dao.CustomerDAO;
import com.hr.springbootwebflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerHandler {

	@Autowired
	private CustomerDAO customerDAO;
	
	public Mono<ServerResponse> getCustomers(final ServerRequest request)
	{
		final Flux<Customer> customerList = customerDAO.getCustomerStream();
		return ServerResponse.ok().body(customerList,Customer.class);
	}
	
	public Mono<ServerResponse> findCustomer(final ServerRequest serverRequest)
	{
		final Integer customerId = Integer.parseInt(serverRequest.pathVariable("id"));
		final Mono<Customer> custMono = customerDAO.getCustomerStream().filter(c->c.getId()==customerId).next();
		return ServerResponse.ok().body(custMono, Customer.class);
	}
	
	public Mono<ServerResponse> saveCustomer(final ServerRequest serverRequest)
	{
		final Mono<Customer> customerMono = serverRequest.bodyToMono(Customer.class);
		// Just returning a string. Actual save will happen once db integration is done
		final Mono<String> response = customerMono.map(c -> c.getId()+ ":"+c.getName()); 
		return ServerResponse.ok().body(response, String.class);
	}
}
