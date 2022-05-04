package com.hr.springbootwebflux.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.springbootwebflux.dto.Customer;
import com.hr.springbootwebflux.service.CustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/blocking")
	public List<Customer> getAllCustomers()
	{
		return customerService.loadAllCustomers();
	}
	
	@GetMapping(value = "/non-blocking", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux <Customer> getAllCustomersStream()
	{
		return customerService.loadAllCustomerStream();
	}
	
}
