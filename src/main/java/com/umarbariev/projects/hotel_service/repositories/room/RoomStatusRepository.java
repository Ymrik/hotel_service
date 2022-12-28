package com.umarbariev.projects.hotel_service.repositories.room;

import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomStatusRepository extends JpaRepository<RoomStatus, Integer> {
    public Optional<RoomStatus> findById(int id);
}
