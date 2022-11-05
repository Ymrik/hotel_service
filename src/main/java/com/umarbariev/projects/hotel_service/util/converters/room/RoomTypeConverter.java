package com.umarbariev.projects.hotel_service.util.converters.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomTypeDto;
import com.umarbariev.projects.hotel_service.entities.room.RoomType;

import java.util.stream.Collectors;

public class RoomTypeConverter {
    public static RoomTypeDto toDto(RoomType roomType) {
        var roomClassDto = RoomClassConverter.toDto(roomType.getRoomClass());
        var roomFeatureDto = roomType.getRoomFeatures()
                .stream()
                .map(RoomFeatureConverter::toDto)
                .collect(Collectors.toList());

        return RoomTypeDto.builder()
                .id(roomType.getId())
                .square(roomType.getSquare())
                .roomClassDto(roomClassDto)
                .basePrice(roomType.getBasePrice())
                .capacity(roomType.getCapacity())
                .photoUrl(roomType.getPhotoUrl())
                .roomFeaturesDto(roomFeatureDto)
                .build();
    }

    public static RoomType fromDto(RoomTypeDto roomTypeDto) {
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
