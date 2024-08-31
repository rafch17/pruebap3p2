package com.espe.chanchay.pruebap3p2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espe.chanchay.pruebap3p2.model.Cliente;
import com.espe.chanchay.pruebap3p2.service.ClienteService;


@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<String> registrarCliente(@RequestBody Cliente cliente) {
        
        try {
            String message = this.clienteService.registrarCliente(cliente);
            return ResponseEntity.ok(message);
        } catch (RuntimeException rte) {
            return ResponseEntity.badRequest().build();
        }
    }

}
