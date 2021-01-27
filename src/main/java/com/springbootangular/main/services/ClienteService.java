package com.springbootangular.main.services;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.repository.ClienteRepository;
import com.springbootangular.main.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

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

    public Cliente findById(Integer id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public void updateById(Integer id, Cliente entity){
        Cliente obj = repository.getOne(id);
        updateData(obj, entity);
        repository.save(obj);
    }


    public void updateData(Cliente obj, Cliente entity){
        obj.setNome(entity.getNome());
        obj.setCpf(entity.getCpf());
        obj.setDataCadastro(Instant.now());
    }

}
