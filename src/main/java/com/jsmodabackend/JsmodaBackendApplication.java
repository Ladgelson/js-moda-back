package com.jsmodabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JsmodaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsmodaBackendApplication.class, args);
	}

}
