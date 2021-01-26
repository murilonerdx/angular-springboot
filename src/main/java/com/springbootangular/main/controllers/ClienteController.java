package com.springbootangular.main.controllers;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.repository.ClienteRepository;
import com.springbootangular.main.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@Controller
@RequestMapping("/api/clientes")
public class ClienteController {


    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service){
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> insert(@RequestBody Cliente obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}