package com.umarbariev.projects.hotel_service.dto.room;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoomStatusDto {
    public final static RoomStatusDto ROOM_STATUS_AVAILABLE = new RoomStatusDto(1,"Available");
    public final static RoomStatusDto ROOM_STATUS_BOOKED = new RoomStatusDto(2,"Booked");
    public final static RoomStatusDto ROOM_STATUS_IN_USE = new RoomStatusDto(1,"In use");

    private int id;

    private String name;
}
