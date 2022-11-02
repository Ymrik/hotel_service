package com.umarbariev.projects.hotel_service.util.converters;

import com.umarbariev.projects.hotel_service.dto.RoomStatusDto;
import com.umarbariev.projects.hotel_service.entities.RoomStatus;

public class RoomStatusConverter {
    public static RoomStatusDto toDto(RoomStatus roomStatus) {
        return RoomStatusDto
                .builder()
                .id(roomStatus.getId())
                .name(roomStatus.getName())
                .build();
    }

    public static RoomStatus fromDto(RoomStatusDto roomStatusDto) {
        var roomStatus = new RoomStatus();
        roomStatus.setId(roomStatusDto.getId());
        roomStatus.setName(roomStatusDto.getName());
        return roomStatus;
    }
}
