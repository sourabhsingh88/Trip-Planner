package com.amstech.tripplanner.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




/**
 * 
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.amstech.tripplanner.booking.repo")
@EntityScan(basePackages = "com.amstech.tripplanner.booking.entity") 
@ComponentScan(basePackages = "com.amstech.tripplanner.booking")
public class Main {
	public static void main(String[] args) { 
		SpringApplication.run(Main.class, args) ;  
	}
}


