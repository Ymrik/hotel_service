package com.umarbariev.projects.hotel_service.repositories.client;

import com.umarbariev.projects.hotel_service.entities.client.LoyaltyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoyaltyStatusRepository extends JpaRepository<LoyaltyStatus, Integer> {
    Optional<LoyaltyStatus> findById(int id);
}
