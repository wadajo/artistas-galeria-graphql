package com.example.databases;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableJpaRepositories
public class DatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabasesApplication.class, args);
	}

}
