package com.entrevista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EntrevistaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrevistaSpringBootApplication.class, args);
	}

}
