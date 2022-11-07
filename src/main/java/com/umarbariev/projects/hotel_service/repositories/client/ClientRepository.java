package com.umarbariev.projects.hotel_service.repositories.client;

import com.umarbariev.projects.hotel_service.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
