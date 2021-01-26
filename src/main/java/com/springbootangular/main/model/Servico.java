package com.springbootangular.main.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToMany
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Servico(Integer id, String descricao, Cliente cliente) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    public Servico(){

    }


}
