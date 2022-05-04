package com.hr.springbootwebflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxTest {

	@Test
	public void testFlux()
	{
		System.out.println("------- Flux TEST ---------");
		Flux<String> fluxString = Flux.just("A","B","C").log();
		fluxString.subscribe(System.out::println);
	}
	
	@Test
	public void testFlux_addvalues()
	{
		System.out.println("------- Flux TEST WITH EXTRA VALUES ---------");
		Flux<String> fluxString = Flux.just("A","B","C")
				.concatWithValues("D","E").log();
		fluxString.subscribe(System.out::println);
	}
	
	@Test
	public void testFlux_error()
	{
		System.out.println("------- Flux TEST WITH ERROR ---------");
		Flux<String> fluxString = Flux.just("A","B","C")
				.concatWith(Flux.error(new RuntimeException("Exception occured.")))
				.concatWithValues("D","E").log(); // D & E will not be broadcasted because of the error
		
		fluxString.subscribe(System.out::println, (e)->System.out.print("ERROR IS >> "+e.getMessage()));
	}
}
