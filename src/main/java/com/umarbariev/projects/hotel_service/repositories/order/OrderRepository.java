package com.umarbariev.projects.hotel_service.repositories.order;

import com.umarbariev.projects.hotel_service.entities.order.Order;
import com.umarbariev.projects.hotel_service.entities.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findLastByRoom(Room room);

    List<Order> getOrdersByClientId(int clientId);
}
