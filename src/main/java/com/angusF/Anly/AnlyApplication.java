package com.angusF.Anly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AnlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnlyApplication.class, args);
	}

}
