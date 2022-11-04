package com.umarbariev.projects.hotel_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeDto {
    private int id;

    private int square;

    private RoomClassDto roomClassDto;

    private Double basePrice;

    private int capacity;

    private String photoUrl;

    private List<RoomFeatureDto> roomFeaturesDto;
}
