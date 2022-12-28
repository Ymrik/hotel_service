package com.umarbariev.projects.hotel_service.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
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
    @JsonProperty("client")
    private ClientDto clientDto;
    @JsonProperty("room")
    private RoomDto roomDto;

    private Date ds;

    private Date de;

    private int guestsCount;

    private Double cost;

    @JsonProperty("orderStatus")
    private OrderStatusDto orderStatusDto;
}
