package com.umarbariev.projects.hotel_service.repositories.client;

import com.umarbariev.projects.hotel_service.entities.client.LoyaltyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyStatusRepository extends JpaRepository<LoyaltyStatus, Integer> {
}
