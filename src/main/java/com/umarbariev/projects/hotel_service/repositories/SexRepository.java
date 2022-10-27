package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.Sex;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SexRepository extends JpaRepository<Sex, Integer> {
}
