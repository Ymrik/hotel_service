package com.umarbariev.projects.hotel_service.entities.room;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_types")
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id")
    private int id;
    @Column(name = "square")
    private int square;
    @ManyToOne
    @JoinColumn(name = "room_class_id")
    private RoomClass roomClass;
    @Column(name = "base_price")
    private Double basePrice;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "photo_url")
    private String photoUrl;
    @ManyToMany
    @JoinTable(
            name = "room_types_room_features",
            joinColumns = {@JoinColumn(name = "room_type_id")},
            inverseJoinColumns = {@JoinColumn(name = "room_feature_id")}
    )
    private List<RoomFeature> roomFeatures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public RoomClass getRoomClass() {
        return roomClass;
    }

    public void setRoomClass(RoomClass roomClass) {
        this.roomClass = roomClass;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<RoomFeature> getRoomFeatures() {
        return roomFeatures;
    }

    public void setRoomFeatures(List<RoomFeature> roomFeatures) {
        this.roomFeatures = roomFeatures;
    }
}
