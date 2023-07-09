package com.lsb.hj01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Hj01Application {

	public static void main(String[] args) {
		SpringApplication.run(Hj01Application.class, args);
	}

}
