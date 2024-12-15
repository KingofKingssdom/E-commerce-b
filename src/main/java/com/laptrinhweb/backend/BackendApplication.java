package com.laptrinhweb.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Cho phép tất cả endpoint
						.allowedOrigins("http://localhost:3000") // Cho phép từ nguồn gốc này
						.allowedMethods("*") // Cho phép tất cả phương thức (GET, POST, PUT, DELETE, etc.)
						.allowedHeaders("*"); // Cho phép tất cả header
			}
		};
	}
}
