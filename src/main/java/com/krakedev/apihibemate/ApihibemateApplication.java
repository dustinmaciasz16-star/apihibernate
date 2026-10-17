package com.krakedev.apihibemate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.krakedev")
@EnableJpaRepositories(basePackages = "com.krakedev")
@EntityScan(basePackages = "com.krakedev")
public class ApihibemateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApihibemateApplication.class, args);
	}

}
