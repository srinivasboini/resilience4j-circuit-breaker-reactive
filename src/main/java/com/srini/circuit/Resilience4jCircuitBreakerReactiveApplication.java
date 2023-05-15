package com.srini.circuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * The type Resilience 4 j circuit breaker reactive application.
 */
@SpringBootApplication
public class Resilience4jCircuitBreakerReactiveApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Resilience4jCircuitBreakerReactiveApplication.class, args);
	}

	/**
	 * Web client web client.
	 *
	 * @return the web client
	 */
	@Bean
	public WebClient webClient(){
		return WebClient.builder()
				.baseUrl("https://dummyhost:8080").build() ;
	}

}
