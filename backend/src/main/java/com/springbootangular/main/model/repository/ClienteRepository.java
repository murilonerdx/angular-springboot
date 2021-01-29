package com.springbootangular.main.model.repository;

import com.springbootangular.main.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
}
