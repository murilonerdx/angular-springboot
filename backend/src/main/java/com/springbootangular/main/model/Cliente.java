package com.springbootangular.main.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 120)
    @NotEmpty(message = "O nome é obrigatorio")
    private String nome;
    @Column(nullable = false, length = 120)
    @NotNull(message = "CPF é obrigatorio.")
    @CPF(message = "CPF está invalido")
    private String cpf;
    private Instant dataCadastro;

}
