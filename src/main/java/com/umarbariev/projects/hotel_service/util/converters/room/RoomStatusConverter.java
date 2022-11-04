package com.umarbariev.projects.hotel_service.util.converters.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;

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
