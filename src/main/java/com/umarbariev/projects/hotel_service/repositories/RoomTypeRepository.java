package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
}
