package com.umarbariev.projects.hotel_service.util.converters;

import com.umarbariev.projects.hotel_service.dto.RoomFeatureDto;
import com.umarbariev.projects.hotel_service.entities.RoomFeature;

public class RoomFeatureConverter {
    public static RoomFeatureDto toDto(RoomFeature roomFeature) {
        var roomFeatureTypeDto = RoomFeatureTypeConverter.toDto(roomFeature.getRoomFeatureType());
        return RoomFeatureDto.builder()
                .id(roomFeature.getId())
                .name(roomFeature.getName())
                .roomFeatureType(roomFeatureTypeDto)
                .build();
    }

    public static RoomFeature fromDto(RoomFeatureDto roomFeatureDto) {
        var roomFeature = new RoomFeature();
        var roomFeatureType = RoomFeatureTypeConverter.fromDto(roomFeatureDto.getRoomFeatureType());
        roomFeature.setId(roomFeatureDto.getId());
        roomFeature.setName(roomFeature.getName());
        roomFeature.setRoomFeatureType(roomFeatureType);
        return roomFeature;
    }
}
