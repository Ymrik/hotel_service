package com.umarbariev.projects.hotel_service.repositories.room;

import com.umarbariev.projects.hotel_service.entities.room.RoomFeature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFeatureRepository extends JpaRepository<RoomFeature, Integer> {
}
