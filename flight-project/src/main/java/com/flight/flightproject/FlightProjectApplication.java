package com.flight.flightproject;
import org.springframework.scheduling.annotation.EnableScheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableScheduling
public class FlightProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightProjectApplication.class, args);
	}

}
