package com.umarbariev.projects.hotel_service.dto.room;

import com.umarbariev.projects.hotel_service.entities.room.RoomTypeDto;
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

    private RoomTypeDto roomTypeDto;

    private RoomStatusDto roomStatusDto;
}
