package com.edu.pe.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.apachecommons.CommonsLog;

@SpringBootApplication
@CommonsLog
public class LibreriaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibreriaBackendApplication.class, args);
	}

}
