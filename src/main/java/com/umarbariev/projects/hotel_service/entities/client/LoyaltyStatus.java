package com.umarbariev.projects.hotel_service.entities.client;

import javax.persistence.*;

@Entity
@Table(name = "loyalty_statuses")
public class LoyaltyStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loyalty_status_id")
    private int id;
    @Column(name = "loyalty_status_name")
    private String name;
    @Column(name = "discount")
    private Double discount;
    @Column(name = "orders_count")
    private int ordersCount;


    public int getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(int ordersCount) {
        this.ordersCount = ordersCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
