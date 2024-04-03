package com.uc.supplymgmtapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SupplyMgmtApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyMgmtApiApplication.class, args);
	}

}
