package com.umarbariev.projects.hotel_service.service.order;

import com.umarbariev.projects.hotel_service.dto.order.OrderDto;
import com.umarbariev.projects.hotel_service.dto.order.OrderRequest;
import com.umarbariev.projects.hotel_service.dto.order.OrderStatusDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.entities.order.Order;
import com.umarbariev.projects.hotel_service.entities.order.OrderStatus;
import com.umarbariev.projects.hotel_service.entities.room.Room;
import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;
import com.umarbariev.projects.hotel_service.repositories.order.OrderRepository;
import com.umarbariev.projects.hotel_service.service.client.ClientService;
import com.umarbariev.projects.hotel_service.service.room.RoomService;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ClientService clientService;

    public Date checkReleaseDate(RoomDto roomDto) {
        var lastOrder = orderRepository.findLastByRoom(BasicConverter.convert(roomDto, Room.class)).orElse(null);
        if(lastOrder==null) return null;
        if(lastOrder.getOrderStatus().equals(OrderStatusDto.ORDER_STATUS_FINISHED)) return null;
        return lastOrder.getDe();
    }

    public OrderDto makeNewOrder(OrderRequest orderRequest) {
        var client = clientService.getById(orderRequest.getClientId());
        var room = BasicConverter.convert(roomService.findAvailableRoomByRoomTypeId(orderRequest.getRoomTypeId()), Room.class);
        var order = Order.builder()
                .orderStatus(BasicConverter.convert(OrderStatusDto.ORDER_STATUS_ACTIVE, OrderStatus.class))
                .room(room)
                .client(client)
                .ds(orderRequest.getCheckInDate())
                .de(orderRequest.getCheckOutDate())
                .guestsCount(orderRequest.getGuestsCount())
                .build();
        var roomStatusBooked = BasicConverter.convert(RoomStatusDto.ROOM_STATUS_BOOKED, RoomStatus.class);
        room.setRoomStatus(roomStatusBooked);
        roomService.createOrUpdateRoom(room);

        return BasicConverter.convert(orderRepository.save(order), OrderDto.class);
    }
}
