package com.umarbariev.projects.hotel_service.service.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.repositories.room.RoomStatusRepository;
import com.umarbariev.projects.hotel_service.util.converters.room.RoomStatusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService {
    @Autowired
    private RoomStatusRepository roomStatusRepository;

    public RoomStatusDto roomStatusAvailable() {
        var roomStatus = roomStatusRepository.findById(1).orElse(null);
        return roomStatus == null ? null : RoomStatusConverter.toDto(roomStatus);
    }

    public RoomStatusDto roomStatusBooked() {
        var roomStatus = roomStatusRepository.findById(2).orElse(null);
        return roomStatus == null ? null : RoomStatusConverter.toDto(roomStatus);
    }

    public RoomStatusDto roomStatusInUse() {
        var roomStatus = roomStatusRepository.findById(3).orElse(null);
        return roomStatus == null ? null : RoomStatusConverter.toDto(roomStatus);
    }
}
