package com.kikidilivery.api;

import org.springframework.boot.SpringApplication;

public class TestKikidiliveryApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(KikidiliveryApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
