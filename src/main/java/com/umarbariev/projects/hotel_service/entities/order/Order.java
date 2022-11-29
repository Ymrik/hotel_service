package com.umarbariev.projects.hotel_service.entities.order;


import com.umarbariev.projects.hotel_service.entities.client.Client;
import com.umarbariev.projects.hotel_service.entities.room.Room;
import lombok.Builder;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "orders")
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "ds")
    private Date ds;
    @Column(name = "de")
    private Date de;
    @Column(name = "guests_count")
    private int guestsCount;
    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(int id, Client client, Room room, Date ds, Date de, int guestsCount, OrderStatus orderStatus) {
        this.id = id;
        this.client = client;
        this.room = room;
        this.ds = ds;
        this.de = de;
        this.guestsCount = guestsCount;
        this.orderStatus = orderStatus;
    }

    public int getGuestsCount() {
        return guestsCount;
    }

    public void setGuestsCount(int guestsCount) {
        this.guestsCount = guestsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDs() {
        return ds;
    }

    public void setDs(Date ds) {
        this.ds = ds;
    }

    public Date getDe() {
        return de;
    }

    public void setDe(Date de) {
        this.de = de;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
