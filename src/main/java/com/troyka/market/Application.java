package com.troyka.market;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer(){
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/products/**")
						.allowedOrigins("http://localhost:3005")
						.allowedMethods("GET","POST")
						.maxAge(3600);
				registry.addMapping("/auth/**")
						.allowedOrigins("http://localhost:3005")
						.allowedMethods("POST")
						.allowedHeaders("Authorization")
						.maxAge(3600);
			}
		};
	}

}
