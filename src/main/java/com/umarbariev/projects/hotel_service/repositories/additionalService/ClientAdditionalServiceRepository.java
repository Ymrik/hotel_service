package com.umarbariev.projects.hotel_service.repositories.additionalService;

import com.umarbariev.projects.hotel_service.entities.additionalService.ClientAdditionalService;
import com.umarbariev.projects.hotel_service.entities.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientAdditionalServiceRepository extends JpaRepository<ClientAdditionalService, Integer> {
    List<ClientAdditionalService> findAllByClientId(int clientId);
}
