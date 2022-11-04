package com.umarbariev.projects.hotel_service.repositories.room;

import com.umarbariev.projects.hotel_service.entities.room.RoomClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomClassRepository extends JpaRepository<RoomClass, Integer> {
}
