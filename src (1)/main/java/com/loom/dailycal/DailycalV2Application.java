package com.loom.dailycal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class DailycalV2Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DailycalV2Application.class, args);
	}

}
