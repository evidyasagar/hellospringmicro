package com.example.helloworldspringboot;

/*import jdk.nashorn.internal.runtime.logging.Logger;*/

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * below are the annotations used to call appropriate packages, classes and its relevant methods
 */

//@RestControlle

@SpringBootApplication
//@EnablePrometheusEndpoint
// @Logger
@EnableScheduling
public class HelloworldSpringbootApplication
{
	//private static final Logger LOGGER=LoggerFactory.getLogger(HelloworldSpringbootApplication.class);

	//@GetMapping("/helloworld")
	//public String getMessage()
	//{

		//return "Greetings from Springboot World ....!!!";
	//}
	public static void main(String[] args)
	{
		SpringApplication.run(HelloworldSpringbootApplication.class, args);
		/*LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);*/
	}

}
