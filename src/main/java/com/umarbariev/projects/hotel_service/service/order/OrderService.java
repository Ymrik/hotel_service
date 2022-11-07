package com.umarbariev.projects.hotel_service.service.order;

import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.repositories.order.OrderRepository;
import com.umarbariev.projects.hotel_service.util.converters.room.RoomConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Date checkReleaseDate(RoomDto roomDto) {
        var lastOrder = orderRepository.findLastByRoom(RoomConverter.fromDto(roomDto)).orElse(null);
        if(lastOrder==null) return null;
        if(lastOrder.getOrderStatus())
    }
}
