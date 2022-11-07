package com.umarbariev.projects.hotel_service.dto.order;

import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.entities.client.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int id;

    //TODO: Switch to ClientDto
    private Client client;

    private RoomDto roomDto;

    private Date ds;

    private Date de;

    private OrderStatusDto orderStatusDto;
}
