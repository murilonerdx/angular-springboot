package com.springbootangular.main.controllers;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.repository.ClienteRepository;
import com.springbootangular.main.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@Controller
@RequestMapping("/api/clientes")
@CrossOrigin("*")
public class ClienteController {


    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Cliente> insert(@RequestBody @Valid Cliente obj) throws ParseException {
        Boolean exists = service.existCpf(obj);
        if (obj.getNome() != null && obj.getCpf() != null && !exists) {
            obj = service.insert(obj);
            return ResponseEntity.ok().body(obj);
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF Já existe no banco de dados");
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            List<Cliente> obj = service.findAll();
            return ResponseEntity.ok().body(obj);
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente obj = service.findById(id);
        if (obj == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }
        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não encontrado");
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateById(@PathVariable @Valid Integer id, @RequestBody Cliente obj) {
        try {
            Boolean exists = service.existCpfById(obj.getCpf());
            if(exists){
                service.updateById(id, obj);
                return ResponseEntity.noContent().build();
            }
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF Já existe no banco de dados");

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

    }
}
