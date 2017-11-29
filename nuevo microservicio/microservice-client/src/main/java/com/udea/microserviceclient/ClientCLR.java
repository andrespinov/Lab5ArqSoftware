package com.udea.microserviceclient;

import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ClientCLR implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {
        Stream.of(new Client("Juan Sebastián", "jsebastian.pelaez@udea.edu.co", "123"),
                new Client("Juan Esteban", "juan.marin11@udea.edu.co", "456"), 
                new Client("Andrés", "andres.pinov@udea.edu.co", "789")).
                forEach(s -> clientRepository.save(s));
        clientRepository.findAll().forEach(System.out::println);
    }
}
