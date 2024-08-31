package com.espe.chanchay.pruebap3p2.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.espe.chanchay.pruebap3p2.model.Cliente;
import com.espe.chanchay.pruebap3p2.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
@Service
public class ClienteService {
    private final ClientRepository clienteRepository;
    private final WebClient webClient;

    public ClienteService(ClientRepository clienteRepository, WebClient.Builder webClientBuilder) {
        this.clienteRepository = clienteRepository;
        this.webClient = webClientBuilder.build();
    }

    public String registrarCliente(Cliente cliente) {
        log.info("creando cliente con cedula: ",cliente.getCedula());
        try {
            if (clienteRepository.existsById(cliente.getCedula())) {
                log.info("Cliente registrado");
                return "El cliente ya está registrado";
            }

            String apiUrl = "http://localhost:8080/api/v1/listaNegra";
            log.info("Consultando servicio externo");

            Integer porcentajeOcurrencia = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path(apiUrl)
                            .queryParam("cedula", cliente.getCedula())
                            .queryParam("apellido", cliente.getApellidos())
                            .queryParam("nombre", cliente.getNombres())
                            .build())
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Integer.class)
                    .block();
                    log.info("incurrencia: "+porcentajeOcurrencia);
            if (porcentajeOcurrencia != null && porcentajeOcurrencia >= 60) {
                return "Cliente no permitido: porcentaje de ocurrencia en listas negras es " + porcentajeOcurrencia;
            }

            clienteRepository.save(cliente);
            log.info("Cliente registrado exitosamente");
            return "Cliente registrado exitosamente";
        } catch (Exception e) {
            log.error("Error al guardar el producto", e);
            return "Error al ingresar cliente";
        }
       

    }
}
