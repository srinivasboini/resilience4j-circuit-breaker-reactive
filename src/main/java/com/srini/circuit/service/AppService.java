package com.srini.circuit.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * The type App service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AppService {

    private final WebClient webClient ;


    /**
     * Get mono.
     *
     * @return the mono
     */
    @CircuitBreaker(name = "serviceA", fallbackMethod = "fallbackA")
    public Mono<String> get(){
        return webClient.get()
                .uri("/api/v1/get")
                .retrieve().bodyToMono(String.class) ;

    }


    private Mono<String> fallbackA(Throwable throwable){
        log.error("{}", throwable) ;
        log.info("Falling back to alternative response ") ;
        return Mono.just("fallback response from resilience4j") ;
    }

}