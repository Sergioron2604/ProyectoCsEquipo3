package com.example.Construccion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.Construccion.Entity")
public class ConstruccionApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConstruccionApplication.class, args);
	}
}
