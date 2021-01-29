package com.springbootangular.main.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ServicoPrestado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    @Column
    private BigDecimal valor;

    @Column
    private LocalDate data;



}
