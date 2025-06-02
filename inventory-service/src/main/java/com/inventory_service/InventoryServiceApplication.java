package com.inventory_service;

import com.inventory_service.model.Inventory;
import com.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {
	@Bean
	CommandLineRunner runner(InventoryRepository repo) {
		return args -> {
			repo.save(new Inventory("Mouse", null, 10));
			repo.save(new Inventory("Teclado", null, 5));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}


}
