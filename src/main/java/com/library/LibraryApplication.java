package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableWebMvc
//@Configuration
//@ComponentScan(basePackages = "com.library.*")
////@ComponentScan(basePackages = "com.library.controller.*")
//@EntityScan("com.library.entity")

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.library.repository")
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

}
