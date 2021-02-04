package com.springbootangular.main.model.repository;

import com.springbootangular.main.model.entity.Cliente;
import com.springbootangular.main.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
