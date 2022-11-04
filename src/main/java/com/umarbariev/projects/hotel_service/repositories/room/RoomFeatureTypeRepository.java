package com.umarbariev.projects.hotel_service.repositories.room;

import com.umarbariev.projects.hotel_service.entities.room.RoomFeatureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomFeatureTypeRepository extends JpaRepository<RoomFeatureType, Integer> {
}
