package com.springbootangular.main.repository;

import com.springbootangular.main.model.Cliente;
import com.springbootangular.main.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Integer> {
}
