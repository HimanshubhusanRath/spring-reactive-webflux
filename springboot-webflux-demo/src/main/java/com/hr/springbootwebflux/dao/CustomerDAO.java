package com.hr.springbootwebflux.dao;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Component;

import com.hr.springbootwebflux.dto.Customer;

import reactor.core.publisher.Flux;

@Component
public class CustomerDAO {

	public List<Customer> getCustomers()
	{
		return IntStream.rangeClosed(1, 10)
				.peek(CustomerDAO::addSleepExecution)
				.peek(i->System.out.println("Processing elements [Blocking] >> "+i))
				.mapToObj(i -> new Customer(i, "customer-"+i)).collect(Collectors.toList());
	}
	
	public Flux<Customer> getCustomerStreamWithDelay()
	{
		return Flux.range(1, 50)
				.delayElements(Duration.ofSeconds(1))
				.doOnNext(i->System.out.println("Processing elements [Non-blocking] >> "+i))
				.map(i -> new Customer(i, "customer-"+i));
	}
	
	public Flux<Customer> getCustomerStream()
	{
		return Flux.range(1, 20)
				.doOnNext(i->System.out.println("Processing elements [Non-blocking] >> "+i))
				.map(i -> new Customer(i, "customer-"+i));
	}
	
	private static void addSleepExecution(final int i)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
