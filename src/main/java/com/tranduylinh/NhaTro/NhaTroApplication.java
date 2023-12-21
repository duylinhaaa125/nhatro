package com.tranduylinh.NhaTro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@SpringBootApplication
@ComponentScan("com.tranduylinh.NhaTro")
@EnableJpaRepositories
public class NhaTroApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(NhaTroApplication.class, args);
	}
	
	

}
