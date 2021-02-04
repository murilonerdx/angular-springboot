package com.springbootangular.main.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Integer id;
    @Column(name="login", unique=true)
    private String username;
    @Column(name="senha")
    private String password;
}
