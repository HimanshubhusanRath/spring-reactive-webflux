package com.hr.springbootwebflux.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.springbootwebflux.dao.CustomerDAO;
import com.hr.springbootwebflux.dto.Customer;

import reactor.core.publisher.Flux;

@Service
public class CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public List<Customer> loadAllCustomers()
	{
		long startTime = System.currentTimeMillis();
		final List<Customer> customers = customerDAO.getCustomers();
		System.out.println("Time taken (in mills) : " + (System.currentTimeMillis()-startTime));
		return customers;
	}
	
	public Flux<Customer> loadAllCustomerStream()
	{
		long startTime = System.currentTimeMillis();
		final Flux<Customer> customers = customerDAO.getCustomerStreamWithDelay();
		System.out.println("Time taken (in mills) : " + (System.currentTimeMillis()-startTime));
		return customers;
	}
}
