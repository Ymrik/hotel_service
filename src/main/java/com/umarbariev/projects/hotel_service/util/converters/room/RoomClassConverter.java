package com.umarbariev.projects.hotel_service.util.converters.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomClassDto;
import com.umarbariev.projects.hotel_service.entities.room.RoomClass;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;

public class RoomClassConverter {
    public static RoomClassDto toDto(RoomClass roomClass) {
        return BasicConverter.convert(roomClass, RoomClassDto.class);
//        return RoomClassDto.builder()
//                .id(roomClass.getId())
//                .name(roomClass.getName())
//                .description(roomClass.getDescription())
//                .build();
    }

    public static RoomClass fromDto(RoomClassDto roomClassDto){
//        var roomClass = new RoomClass();
//        roomClass.setId(roomClassDto.getId());
//        roomClass.setName(roomClass.getName());
//        roomClass.setDescription(roomClassDto.getDescription());
//        return roomClass;
        return BasicConverter.convert(roomClassDto, RoomClass.class);
    }
}
