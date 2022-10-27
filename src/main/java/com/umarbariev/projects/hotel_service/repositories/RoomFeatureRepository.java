package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFeatureRepository extends JpaRepository<RoomFeature, Integer> {
}
