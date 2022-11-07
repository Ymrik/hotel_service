package com.umarbariev.projects.hotel_service.service.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.repositories.room.RoomRepository;
import com.umarbariev.projects.hotel_service.util.converters.room.RoomConverter;
import com.umarbariev.projects.hotel_service.util.converters.room.RoomStatusConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomStatusService roomStatusService;

    public List<RoomDto> getAllAvailableRooms() {
        var roomStatusAvailable = roomStatusService.roomStatusAvailable();
        return roomStatusAvailable == null ? null : roomRepository.findAllByRoomStatus(RoomStatusConverter.fromDto(roomStatusAvailable))
                .stream()
                .map(RoomConverter::toDto)
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(RoomConverter::toDto)
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllRoomsAvailableOnDate(Date date) {
        var allRooms = findAllRooms();
        for (RoomDto roomDto: allRooms) {
            if (roomDto.getRoomStatusDto().equals(RoomStatusDto.ROOM_STATUS_AVAILABLE)) continue;

        }
    }
}
