package com.umarbariev.projects.hotel_service.repositories.additionalService;

import com.umarbariev.projects.hotel_service.entities.additionalService.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Integer> {
}
