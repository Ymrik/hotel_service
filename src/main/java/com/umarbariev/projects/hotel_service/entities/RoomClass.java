package com.umarbariev.projects.hotel_service.entities;

import javax.persistence.*;

@Entity
@Table(name = "room_classes")
public class RoomClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_class_id")
    private int id;
    @Column(name = "room_class_name")
    private String name;
    @Column(name = "description")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
