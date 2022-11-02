package com.umarbariev.projects.hotel_service.util.converters;

import com.umarbariev.projects.hotel_service.dto.RoomTypeDto;
import com.umarbariev.projects.hotel_service.entities.RoomClass;
import com.umarbariev.projects.hotel_service.entities.RoomType;

public class RoomTypeConverter {
    public static RoomTypeDto toDto(RoomType roomType){
        var roomClassDto = RoomClassConverter.toDto(roomType.getRoomClass());
        return RoomTypeDto.builder()
                .id(roomType.getId())
                .square(roomType.getSquare())
                .roomClassDto(roomClassDto)
                .basePrice(roomType.getBasePrice())
                .capacity(roomType.getCapacity())
                .photoUrl(roomType.getPhotoUrl())
                .build();
    }

    public static RoomType fromDto(RoomTypeDto roomTypeDto){
        var roomType = new RoomType();
        var roomClass = RoomClassConverter.fromDto(roomTypeDto.getRoomClassDto());
        roomType.setId(roomTypeDto.getId());
        roomType.setSquare(roomTypeDto.getSquare());
        roomType.setRoomClass(roomClass);
        roomType.setBasePrice(roomTypeDto.getBasePrice());
        roomType.setCapacity(roomTypeDto.getCapacity());
        roomType.setPhotoUrl(roomTypeDto.getPhotoUrl());
        return roomType;
    }
}
