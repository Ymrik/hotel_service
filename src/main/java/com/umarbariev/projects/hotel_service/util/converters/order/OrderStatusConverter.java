package com.umarbariev.projects.hotel_service.util.converters.order;

import com.umarbariev.projects.hotel_service.dto.order.OrderStatusDto;
import com.umarbariev.projects.hotel_service.entities.order.OrderStatus;

public class OrderStatusConverter {
    public static OrderStatusDto toDto(OrderStatus orderStatus){
        return OrderStatusDto.builder()
                .id(orderStatus.getId())
                .name(orderStatus.getName())
                .build();
    }

    public static OrderStatus fromDto(OrderStatusDto orderStatusDto){
        var orderStatus = new OrderStatus();
        orderStatus.setId(orderStatusDto.getId());
        orderStatus.setName(orderStatusDto.getName());
        return orderStatus;
    }
}
