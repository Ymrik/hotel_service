package com.umarbariev.projects.hotel_service.repositories.client;

import com.umarbariev.projects.hotel_service.entities.client.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SexRepository extends JpaRepository<Sex, Integer> {
    Optional<Sex> findByName(String name);
}
