package com.entrevista.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevista.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
}
