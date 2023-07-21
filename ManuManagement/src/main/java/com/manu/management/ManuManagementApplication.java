package com.manu.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ManuManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManuManagementApplication.class, args);
	}

}
