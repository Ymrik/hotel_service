package com.umarbariev.projects.hotel_service.service.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomTypeDto;
import com.umarbariev.projects.hotel_service.repositories.room.RoomTypeRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public RoomTypeDto findById(int roomTypeId) {
        var roomType = roomTypeRepository.findById(roomTypeId).orElse(null);
        return roomType == null ? null : BasicConverter.convert(roomType, RoomTypeDto.class);
    }
}
