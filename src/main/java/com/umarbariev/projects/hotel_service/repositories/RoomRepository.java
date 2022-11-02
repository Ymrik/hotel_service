package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.Room;
import com.umarbariev.projects.hotel_service.entities.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByRoomStatusId(int id);
}
