package com.umarbariev.projects.hotel_service.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umarbariev.projects.hotel_service.dto.room.RoomClassDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomFeatureDto;
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

    private String name;

    private int square;
    @JsonProperty("roomClass")
    private RoomClassDto roomClassDto;

    private Double basePrice;

    private int capacity;

    private String photoUrl;
    @JsonProperty("roomFeatures")
    private List<RoomFeatureDto> roomFeaturesDto;
}
