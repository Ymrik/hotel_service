package com.umarbariev.projects.hotel_service.entities.room;

import javax.persistence.*;

@Entity
@Table(name = "room_features_types")
public class RoomFeatureType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_features_type_id")
    private int id;
    @Column(name = "room_features_type_name")
    private String name;

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
}
