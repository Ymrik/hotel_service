package com.umarbariev.projects.hotel_service.util.converters.room;

import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.entities.room.Room;

public class RoomConverter {
    public static RoomDto toDto(Room room) {
        var roomStatusDto = RoomStatusConverter.toDto(room.getRoomStatus());
        var roomTypeDto = RoomTypeConverter.toDto(room.getRoomType());
        return RoomDto.builder()
                .id(room.getId())
                .roomStatusDto(roomStatusDto)
                .roomTypeDto(roomTypeDto)
                .build();
    }


    public static Room fromDto(RoomDto roomDto) {
        var room = new Room();
        var roomType = RoomTypeConverter.fromDto(roomDto.getRoomTypeDto());
        var roomStatus = RoomStatusConverter.fromDto(roomDto.getRoomStatusDto());
        room.setId(roomDto.getId());
        room.setRoomType(roomType);
        room.setRoomStatus(roomStatus);
        return room;
    }
}
