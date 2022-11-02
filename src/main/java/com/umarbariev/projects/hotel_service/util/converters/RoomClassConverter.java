package com.umarbariev.projects.hotel_service.util.converters;

import com.umarbariev.projects.hotel_service.dto.RoomClassDto;
import com.umarbariev.projects.hotel_service.entities.RoomClass;

public class RoomClassConverter {
    public static RoomClassDto toDto(RoomClass roomClass) {
        return RoomClassDto.builder()
                .id(roomClass.getId())
                .name(roomClass.getName())
                .description(roomClass.getDescription())
                .build();
    }

    public static RoomClass fromDto(RoomClassDto roomClassDto){
        var roomClass = new RoomClass();
        roomClass.setId(roomClassDto.getId());
        roomClass.setName(roomClass.getName());
        roomClass.setDescription(roomClassDto.getDescription());
        return roomClass;
    }
}
