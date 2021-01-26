package com.springbootangular.main.services;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceController {
    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente cliente){
        return repository.save(cliente);
    }
}
