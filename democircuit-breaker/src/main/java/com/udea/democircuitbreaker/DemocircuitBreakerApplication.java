package com.udea.democircuitbreaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DemocircuitBreakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocircuitBreakerApplication.class, args);
	}
}
