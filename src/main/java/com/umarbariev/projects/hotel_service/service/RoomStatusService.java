package com.umarbariev.projects.hotel_service.service;

import com.umarbariev.projects.hotel_service.dto.RoomStatusDto;
import com.umarbariev.projects.hotel_service.repositories.RoomStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomStatusService {
    @Autowired
    private RoomStatusRepository roomStatusRepository;

    public RoomStatusDto roomStatusAvailable(){
        var roomStatus = roomStatusRepository.findById(0).orElse(null);
        return new RoomStatusDto(roomStatus.getId(), roomStatus.getName());
    }

    public RoomStatusDto roomStatusBooked(){
        var roomStatus = roomStatusRepository.findById(1).orElse(null);
        return new RoomStatusDto(roomStatus.getId(), roomStatus.getName());
    }

    public RoomStatusDto roomStatusInUse(){
        var roomStatus = roomStatusRepository.findById(2).orElse(null);
        return new RoomStatusDto(roomStatus.getId(), roomStatus.getName());
    }
}
