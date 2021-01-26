package com.springbootangular.main.services;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente obj){
        if (obj.getDataCadastro() == null) {
            obj.setDataCadastro(Instant.now());
        }
        return repository.save(obj);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }
}
