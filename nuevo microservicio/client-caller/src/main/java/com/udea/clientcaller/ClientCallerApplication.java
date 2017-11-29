package com.udea.clientcaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
@EnableHystrix
@EnableCircuitBreaker
@RestController
@ComponentScan(basePackages = { "com.udea.clientcaller" })
public class ClientCallerApplication {

    private static final String SERVICE_URL = "http://localhost:6666";

    public static void main(String[] args) {
        SpringApplication.run(ClientCallerApplication.class, args);
    }
    
    @LoadBalanced
    @Bean
    public static RestTemplate restTemplate(){
        return new RestTemplate();
    }
    
    @Bean
    public static ClientService productoService(){
        return new ClientService(SERVICE_URL);
    }
    
    @Bean
    public ClientController productoController(){
        return new ClientController();
    }
}
