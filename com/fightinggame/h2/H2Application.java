package com.fightinggame.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class H2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(H2Application.class, args);
	}

}
