package com.hr.springbootwebflux;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Mono;

public class MonoTest {

	@Test
	public void testMono_success()
	{
		Mono<String> str = Mono.just("hello").log();
		str.subscribe(System.out::println);
	}
	
	
	@Test
	public void testMono_error()
	{
		Mono<?> str = Mono.just("hello").then(Mono.error(new RuntimeException())).log();
		str.subscribe(System.out::println, (err)-> System.out.println(err));
	}
	
	@Test
	public void testMono_then_anotherMono()
	{
		Mono<?> str = Mono.just("hello").then(Mono.just("later")).log();
		str.subscribe(System.out::println);
	}
}
