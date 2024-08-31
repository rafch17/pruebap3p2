package com.espe.chanchay.pruebap3p2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.espe.chanchay.pruebap3p2.model.Cliente;

public interface ClientRepository extends JpaRepository<Cliente, String> {
}
