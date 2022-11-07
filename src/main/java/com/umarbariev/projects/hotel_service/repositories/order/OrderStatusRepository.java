package com.umarbariev.projects.hotel_service.repositories.order;

import com.umarbariev.projects.hotel_service.entities.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
