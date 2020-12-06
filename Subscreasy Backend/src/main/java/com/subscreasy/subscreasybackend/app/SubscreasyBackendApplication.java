package com.subscreasy.subscreasybackend.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.subscreasy.subscreasybackend.config")
@ComponentScan("com.subscreasy.subscreasybackend.filter")
@ComponentScan("com.subscreasy.subscreasybackend.auth")
@EntityScan(basePackages = {"com.subscreasy.subscreasybackend.model"})
@EnableJpaRepositories("com.subscreasy.subscreasybackend.repository")
@ComponentScan("com.subscreasy.subscreasybackend.service")
@ComponentScan("com.subscreasy.subscreasybackend.controller")
@ComponentScan("com.subscreasy.subscreasybackend.dto")
@CrossOrigin
public class SubscreasyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscreasyBackendApplication.class, args);
	}

}
