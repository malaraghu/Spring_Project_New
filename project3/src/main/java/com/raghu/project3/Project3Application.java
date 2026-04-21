package com.raghu.project3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Project3Application {

    //added in own laptop
	public static void main(String[] args) {
		SpringApplication.run(Project3Application.class, args);
	}

}
