package com.umarbariev.projects.hotel_service.entities.room;

import javax.persistence.*;

@Entity
@Table(name = "room_features")
public class RoomFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_feature_id")
    private int id;
    @Column(name = "room_feature_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "room_feature_type_id")
    private RoomFeatureType roomFeatureType;

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

    public RoomFeatureType getRoomFeatureType() {
        return roomFeatureType;
    }

    public void setRoomFeatureType(RoomFeatureType roomFeatureType) {
        this.roomFeatureType = roomFeatureType;
    }
}
