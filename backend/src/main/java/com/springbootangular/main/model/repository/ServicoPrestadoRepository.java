package com.springbootangular.main.model.repository;

import com.springbootangular.main.model.entity.ServicoPrestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoPrestadoRepository extends JpaRepository<ServicoPrestado,Integer> {
}
