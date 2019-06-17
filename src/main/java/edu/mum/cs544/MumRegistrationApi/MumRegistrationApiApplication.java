package edu.mum.cs544.MumRegistrationApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MumRegistrationApiApplication {

	@Bean
	public RestTemplate GetrestTemplate()
	{
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MumRegistrationApiApplication.class, args);
	}

}
