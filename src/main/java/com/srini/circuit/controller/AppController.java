package com.srini.circuit.controller;

import com.srini.circuit.service.AppService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * The type App controller.
 */
@RestController
@RequestMapping("/app")
@Slf4j
@RequiredArgsConstructor
public class AppController {

    private final AppService appService ;

    /**
     * Get mono.
     *
     * @return the mono
     */
    @GetMapping("get")
    public Mono<String> get(){
        return appService.get() ;
    }


    @GetMapping("all")
    public Flux<String> getAll(){
        return appService.getAll() ;
    }

}
