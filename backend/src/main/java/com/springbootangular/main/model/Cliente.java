package com.springbootangular.main.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

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
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataCadastro;



}
