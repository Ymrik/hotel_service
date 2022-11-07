package com.umarbariev.projects.hotel_service.service.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;
import com.umarbariev.projects.hotel_service.repositories.room.RoomRepository;
import com.umarbariev.projects.hotel_service.service.order.OrderService;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private RoomStatusService roomStatusService;

    @Autowired
    private OrderService orderService;

    public List<RoomDto> getAllAvailableRooms() {
        var roomStatusAvailable = roomStatusService.roomStatusAvailable();
        return roomStatusAvailable == null ? null : roomRepository.findAllByRoomStatus(BasicConverter.convert(roomStatusAvailable, RoomStatus.class))
                .stream()
                .map(x -> BasicConverter.convert(x, RoomDto.class))
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(x -> BasicConverter.convert(x, RoomDto.class))
                .collect(Collectors.toList());
    }

    public List<RoomDto> findAllRoomsAvailableOnDate(Date date) {
        var allRooms = findAllRooms();
        var availableRooms = new ArrayList<RoomDto>();
        for (RoomDto roomDto : allRooms) {
            if (roomDto.getRoomStatusDto().equals(RoomStatusDto.ROOM_STATUS_AVAILABLE)) {
                availableRooms.add(roomDto);
                continue;
            }
            var releaseDate = orderService.checkReleaseDate(roomDto);
            if (releaseDate.before(date)) availableRooms.add(roomDto);
        }
        return availableRooms;
    }
}
