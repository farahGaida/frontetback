package com.immozone.immozone_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.immozone.immozone_backend"})
public class ImmozoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImmozoneBackendApplication.class, args);
	}

}

































































