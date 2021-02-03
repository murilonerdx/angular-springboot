package com.springbootangular.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class MainApplication {

//    @Bean
//    public CommandLineRunner run(@Autowired ClienteRepository repository){
//        return args ->{
//            Cliente cliente = Cliente.builder().cpf("0000000000").nome("Murilo").dataCadastro(Instant.now()).build();
//            repository.save(cliente);
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }


}
