package com.umarbariev.projects.hotel_service.service.order;

import com.umarbariev.projects.hotel_service.dto.order.OrderStatusDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.entities.room.Room;
import com.umarbariev.projects.hotel_service.repositories.order.OrderRepository;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Date checkReleaseDate(RoomDto roomDto) {
        var lastOrder = orderRepository.findLastByRoom(BasicConverter.convert(roomDto, Room.class)).orElse(null);
        if(lastOrder==null) return null;
        if(lastOrder.getOrderStatus().equals(OrderStatusDto.ORDER_STATUS_FINISHED)) return null;
        return lastOrder.getDe();
    }
}
