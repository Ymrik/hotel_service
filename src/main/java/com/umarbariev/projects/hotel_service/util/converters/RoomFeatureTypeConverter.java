package com.umarbariev.projects.hotel_service.util.converters;

import com.umarbariev.projects.hotel_service.dto.RoomFeatureTypeDto;
import com.umarbariev.projects.hotel_service.entities.RoomFeatureType;

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
