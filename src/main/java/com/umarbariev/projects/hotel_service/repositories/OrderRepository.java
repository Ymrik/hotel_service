package com.umarbariev.projects.hotel_service.repositories;

import com.umarbariev.projects.hotel_service.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
