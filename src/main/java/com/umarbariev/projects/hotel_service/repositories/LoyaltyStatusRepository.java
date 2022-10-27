package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.LoyaltyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoyaltyStatusRepository extends JpaRepository<LoyaltyStatus, Integer> {
}
