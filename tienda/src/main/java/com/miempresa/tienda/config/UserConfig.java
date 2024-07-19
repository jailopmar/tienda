package com.miempresa.tienda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

	@Bean
	public String exampleBean() {
		return "Example Bean";
	}

}
