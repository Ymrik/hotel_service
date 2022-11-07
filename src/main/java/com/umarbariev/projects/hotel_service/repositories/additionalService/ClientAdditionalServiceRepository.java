package com.umarbariev.projects.hotel_service.repositories.additionalService;

import com.umarbariev.projects.hotel_service.entities.additionalService.ClientAdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientAdditionalServiceRepository extends JpaRepository<ClientAdditionalService, Integer> {
}
