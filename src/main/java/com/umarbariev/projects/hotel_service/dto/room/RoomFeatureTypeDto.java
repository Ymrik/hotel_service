package com.umarbariev.projects.hotel_service.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomFeatureTypeDto {
    private int id;

    private String name;
}
