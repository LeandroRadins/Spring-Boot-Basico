package com.amigoscode.springboot.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args -> {
			Student pepe = new Student("Pepe", "pepe@gmail.com", LocalDate.of(1990, Month.MARCH, 25));
			Student juan = new Student("Juan", "juan@gmail.com", LocalDate.of(2002, Month.MARCH, 22));
			repository.saveAll(List.of(pepe, juan));

		};
	}

}
