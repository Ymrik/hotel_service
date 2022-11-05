package com.umarbariev.projects.hotel_service.repositories.room;

import com.umarbariev.projects.hotel_service.entities.room.Room;
import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByRoomStatus(RoomStatus roomStatus);
}
