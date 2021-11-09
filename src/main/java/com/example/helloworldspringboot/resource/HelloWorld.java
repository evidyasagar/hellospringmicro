/*package com.example.helloworldspringboot.resource;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class HelloWorld {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    private final Counter counter;
    public HelloWorld(CollectorRegistry collectorRegistry){
        counter = Counter.build()
                .name("requests_count")
                .help("Total Requests")
                .register(collectorRegistry);

    }

    @GetMapping("/hello")

    public String Hello()
    {
        counter.inc();
        return "Greetings from HelloWorld App!!!";
    }

 }*/
