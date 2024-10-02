package com.hr.springbootwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableAsync
public class SpringbootWebfluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);
	}

	@Bean
	WebClient webClient() {
		return WebClient.builder().build();
	}

}
