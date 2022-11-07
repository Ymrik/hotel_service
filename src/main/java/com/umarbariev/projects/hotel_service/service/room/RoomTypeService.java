package com.umarbariev.projects.hotel_service.service.room;

import com.umarbariev.projects.hotel_service.dto.SearchCriteriaDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomTypeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomTypeService {
    @Autowired
    private RoomService roomService;

    public List<RoomTypeDto> getAllAvailableRoomTypes() {
        return roomService.getAllAvailableRooms()
                .stream()
                .map(x -> x.getRoomTypeDto())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<RoomTypeDto> getAvailableRoomTypesBySearchCriteria(SearchCriteriaDto searchCriteria) {
        var allRooms = roomService.findAllRooms();

    }
}
