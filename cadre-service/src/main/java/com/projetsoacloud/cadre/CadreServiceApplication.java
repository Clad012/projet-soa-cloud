package com.projetsoacloud.cadre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CadreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadreServiceApplication.class, args);
	}

}
