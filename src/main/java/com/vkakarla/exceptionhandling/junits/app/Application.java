package com.vkakarla.exceptionhandling.junits.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(title = "Employee Project", version = "0.0.1-SNAPSHOT", description = "Employee Service Operations", termsOfService = "vkakarla java springboot service", contact = @Contact(name = "vkakarl", email = "vkakarla1985@gmail.com"), license = @License(name = "vkakarla", url = "http://youtube.com/vkakarla")))
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/employee-error-messages");
		return messageSource;
	}

}
