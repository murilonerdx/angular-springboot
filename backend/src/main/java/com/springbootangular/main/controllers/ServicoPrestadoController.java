package com.springbootangular.main.controllers;

import com.springbootangular.main.controllers.dto.ServicoPrestadoDTO;
import com.springbootangular.main.controllers.util.BigDecimalConverter;
import com.springbootangular.main.model.entity.Cliente;
import com.springbootangular.main.model.entity.ServicoPrestado;
import com.springbootangular.main.model.repository.ClienteRepository;
import com.springbootangular.main.model.repository.ServicoPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@Controller
@RequestMapping(value="/api/servicos-prestados")
public class ServicoPrestadoController {

    private final BigDecimalConverter bigDecimalConverter;

    @Autowired
    private final ClienteRepository clienteRepository;

    @Autowired
    private final ServicoPrestadoRepository servicoPrestadoRepository;


    public ServicoPrestadoController(BigDecimalConverter bigDecimalConverter, ClienteRepository clienteRepository, ServicoPrestadoRepository servicoPrestadoRepository) {
        this.bigDecimalConverter = bigDecimalConverter;
        this.clienteRepository = clienteRepository;
        this.servicoPrestadoRepository = servicoPrestadoRepository;
    }

    @PostMapping()
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.now();LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente não existe"));

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor(bigDecimalConverter.converter(dto.getPreco()));
        return servicoPrestadoRepository.save(servicoPrestado);

    }
}
