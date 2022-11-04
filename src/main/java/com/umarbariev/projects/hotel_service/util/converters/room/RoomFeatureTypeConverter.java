package com.umarbariev.projects.hotel_service.util.converters.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomFeatureTypeDto;
import com.umarbariev.projects.hotel_service.entities.room.RoomFeatureType;

public class RoomFeatureTypeConverter {
    public static RoomFeatureTypeDto toDto(RoomFeatureType roomFeatureType) {
        return RoomFeatureTypeDto.builder()
                .id(roomFeatureType.getId())
                .name(roomFeatureType.getName())
                .build();
    }

    public static RoomFeatureType fromDto(RoomFeatureTypeDto roomFeatureTypeDto) {
        var roomFeatureType = new RoomFeatureType();
        roomFeatureType.setId(roomFeatureTypeDto.getId());
        roomFeatureType.setName(roomFeatureTypeDto.getName());
        return roomFeatureType;
    }
}
