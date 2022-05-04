package com.hr.springbootwebflux.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.hr.springbootwebflux.dao.CustomerDAO;
import com.hr.springbootwebflux.dto.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerStreamHandler {

	@Autowired
	private CustomerDAO customerDAO;
	
	public Mono<ServerResponse> getCustomerStream(final ServerRequest request)
	{
		final Flux<Customer> customerList = customerDAO.getCustomerStreamWithDelay();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM) // Makes this an asynchronous response
				.body(customerList,Customer.class);
	}
}
