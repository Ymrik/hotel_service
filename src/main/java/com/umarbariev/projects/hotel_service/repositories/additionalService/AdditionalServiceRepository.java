package com.umarbariev.projects.hotel_service.repositories.additionalService;

import com.umarbariev.projects.hotel_service.entities.additionalService.AdditionalService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdditionalServiceRepository extends JpaRepository<AdditionalService, Integer> {
    List<AdditionalService> findAllByEnabledTrue();

    Optional<AdditionalService> findById(int serviceId);
}
