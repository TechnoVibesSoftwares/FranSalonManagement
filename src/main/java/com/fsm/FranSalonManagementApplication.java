package com.fsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class FranSalonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranSalonManagementApplication.class, args);
	}
	
	public WebMvcConfigurer crosConfigurer() {
    	return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// TODO Auto-generated method stub
				registry.addMapping("/*").allowedHeaders("*")
				.allowedOrigins("*").allowCredentials(true);
			}
    		
		};
    }

}
