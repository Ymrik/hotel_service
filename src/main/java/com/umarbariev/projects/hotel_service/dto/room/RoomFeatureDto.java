package com.umarbariev.projects.hotel_service.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomFeatureDto {
    private int id;

    private String name;

    private RoomFeatureTypeDto roomFeatureType;
}
