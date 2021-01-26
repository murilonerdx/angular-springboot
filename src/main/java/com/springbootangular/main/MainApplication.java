package com.springbootangular.main;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args ->{
            Cliente cliente = Cliente.builder().cpf("0000000000").nome("Murilo").build();
            repository.save(cliente);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


}
