package com.umarbariev.projects.hotel_service.service;

import com.umarbariev.projects.hotel_service.dto.RoomDto;
import com.umarbariev.projects.hotel_service.repositories.RoomRepository;
import com.umarbariev.projects.hotel_service.util.converters.RoomConverter;
import com.umarbariev.projects.hotel_service.util.converters.RoomStatusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    private RoomStatusService roomStatusService;

    public List<RoomDto> getAllAvailableRooms(){
        var roomStatusAvailable = roomStatusService.roomStatusAvailable();
        return roomRepository.findAllByRoomStatusId(roomStatusAvailable.getId())
                .stream()
                .map(RoomConverter::toDto)
                .collect(Collectors.toList());
    }
}
