package com.springbootangular.main.services;

import com.springbootangular.main.model.entity.Cliente;
import com.springbootangular.main.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente obj) {

        obj.setCpf(obj.getCpf().replaceAll("[^0-9]+", ""));
        if (obj.getDataCadastro() == null) {
            obj.setDataCadastro(new Date());
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

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public void updateById(Integer id, Cliente entity) {
        Cliente obj = repository.getOne(id);
        updateData(obj, entity);
        repository.save(obj);
    }


    public void updateData(Cliente obj, Cliente entity) {
        obj.setNome(entity.getNome());
        obj.setCpf(entity.getCpf());
        obj.setCpf(obj.getCpf().replaceAll("[^0-9]+", ""));
        obj.setDataCadastro(new Date());
    }

    public Boolean existCpf(Cliente obj) {
        List<Cliente> novaLista = findAll();
        boolean exist = novaLista.stream().map(Cliente::getCpf).anyMatch(y -> y.equals(obj.getCpf()));
        novaLista.clear();
        return exist;
    }

}
