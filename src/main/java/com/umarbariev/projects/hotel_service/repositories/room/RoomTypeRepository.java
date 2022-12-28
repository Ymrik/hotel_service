package com.umarbariev.projects.hotel_service.repositories.room;

import com.umarbariev.projects.hotel_service.entities.room.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {
}
