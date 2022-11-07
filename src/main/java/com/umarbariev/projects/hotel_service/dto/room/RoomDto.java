package com.umarbariev.projects.hotel_service.dto.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private int id;
    @JsonProperty("roomType")
    private RoomTypeDto roomTypeDto;
    @JsonProperty("roomStatus")
    private RoomStatusDto roomStatusDto;
}
