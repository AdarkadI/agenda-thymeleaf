package com.example.agenda_thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AgendaThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaThymeleafApplication.class, args);
	}

}
