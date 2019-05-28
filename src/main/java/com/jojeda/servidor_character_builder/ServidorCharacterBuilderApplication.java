package com.jojeda.servidor_character_builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ServidorCharacterBuilderApplication extends SpringBootServletInitializer {


	private static Class<ServidorCharacterBuilderApplication> applicationClass = ServidorCharacterBuilderApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(ServidorCharacterBuilderApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(applicationClass);
	}
}
