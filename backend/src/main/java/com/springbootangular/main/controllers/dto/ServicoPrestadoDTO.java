package com.springbootangular.main.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoPrestadoDTO {

    @NotEmpty(message = "O campo descrição é obrigatorio")
    private String descricao;

    @NotEmpty(message = "O campo preço é obrigatorio")
    private String preco;

    @NotEmpty(message = "O campo data é obrigatorio")
    private String data;
    private Integer idCliente;
}
