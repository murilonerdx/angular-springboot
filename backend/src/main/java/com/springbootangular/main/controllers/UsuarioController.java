package com.springbootangular.main.controllers;

import com.springbootangular.main.model.entity.Usuario;
import com.springbootangular.main.model.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private final UsuarioRepository repository;

    @PostMapping()
    public void salvar(@RequestBody @Valid Usuario usuario){
        repository.save(usuario);
    }
}
