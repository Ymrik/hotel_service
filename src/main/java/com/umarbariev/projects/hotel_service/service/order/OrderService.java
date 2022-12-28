package com.umarbariev.projects.hotel_service.service.order;

import com.umarbariev.projects.hotel_service.dto.client.ClientDto;
import com.umarbariev.projects.hotel_service.dto.order.OrderDto;
import com.umarbariev.projects.hotel_service.dto.order.OrderRequest;
import com.umarbariev.projects.hotel_service.dto.order.OrderStatusDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomDto;
import com.umarbariev.projects.hotel_service.dto.room.RoomStatusDto;
import com.umarbariev.projects.hotel_service.entities.client.Client;
import com.umarbariev.projects.hotel_service.entities.client.LoyaltyStatus;
import com.umarbariev.projects.hotel_service.entities.order.Order;
import com.umarbariev.projects.hotel_service.entities.order.OrderStatus;
import com.umarbariev.projects.hotel_service.entities.room.Room;
import com.umarbariev.projects.hotel_service.entities.room.RoomStatus;
import com.umarbariev.projects.hotel_service.repositories.order.OrderRepository;
import com.umarbariev.projects.hotel_service.service.client.ClientService;
import com.umarbariev.projects.hotel_service.service.room.RoomService;
import com.umarbariev.projects.hotel_service.service.room.RoomTypeService;
import com.umarbariev.projects.hotel_service.util.DateHelper;
import com.umarbariev.projects.hotel_service.util.converters.BasicConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private RoomTypeService roomTypeService;

    public Date checkReleaseDate(RoomDto roomDto) {
        var lastOrder = orderRepository.findLastByRoom(BasicConverter.convert(roomDto, Room.class)).orElse(null);
        if (lastOrder == null) return null;
        if (lastOrder.getOrderStatus().equals(OrderStatusDto.ORDER_STATUS_FINISHED)) return null;
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
        order.setCost(getOrderCost(orderRequest));
        var infoUntilNextLoyaltyStatus = clientService
                .getInfoUntilNextLoyaltyStatus(BasicConverter.convert(client, ClientDto.class));
        var ordersForNextStatus = infoUntilNextLoyaltyStatus.getOrdersForNextStatus();
        if (ordersForNextStatus == 1) {
            var nextStatusDto = infoUntilNextLoyaltyStatus.getNext();
            client.setLoyaltyStatus(BasicConverter.convert(nextStatusDto, LoyaltyStatus.class));
            clientService.save(client);
        }
        return BasicConverter.convert(orderRepository.save(order), OrderDto.class);
    }

    public Double getOrderCost(OrderRequest orderRequest) {
        var days = DateHelper.getDaysBetweenDates(orderRequest.getCheckInDate(), orderRequest.getCheckOutDate());
        var roomType = roomTypeService.findById(orderRequest.getRoomTypeId());
        var client = clientService.getById(orderRequest.getClientId());
        var pricePerDay = roomType.getBasePrice() * (1 - client.getLoyaltyStatus().getDiscount() / 100);
        return pricePerDay * days;
    }

    public int getOrdersCountForClient(ClientDto clientDto) {
        return getOrdersCountByClientId(clientDto.getId());
    }

    public int getOrdersCountByClientId(int clientId) {
        var ordersForClient = getOrdersByClientId(clientId);
        return ordersForClient.size();
    }

    public List<OrderDto> getActiveOrdersByClient(ClientDto client) {
        return getOrdersByClient(client)
                .stream()
                .filter(order -> order.getOrderStatusDto().getId() == 2)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getFinishedOrdersByClient(ClientDto client) {
        return getOrdersByClient(client)
                .stream()
                .filter(order -> order.getOrderStatusDto().getId() == 3)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getOrdersByClient(ClientDto client) {
        return getOrdersByClientId(client.getId());
    }

    public List<OrderDto> getOrdersByClientId(int clientId) {
        return orderRepository.getOrdersByClientId(clientId)
                .stream()
                .map(order -> BasicConverter.convert(order, OrderDto.class))
                .collect(Collectors.toList());
    }
}
