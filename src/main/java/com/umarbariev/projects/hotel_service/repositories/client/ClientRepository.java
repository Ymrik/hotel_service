package com.umarbariev.projects.hotel_service.repositories.client;

import com.umarbariev.projects.hotel_service.entities.User;
import com.umarbariev.projects.hotel_service.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByUser(User user);
    Optional<Client> findByUserUsername(String username);
}
