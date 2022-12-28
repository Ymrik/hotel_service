package com.umarbariev.projects.hotel_service.entities.special_offer;

import com.umarbariev.projects.hotel_service.entities.room.RoomType;

import javax.persistence.*;

@Entity
@Table(name = "special_offers_room_types")
public class SpecialOfferRoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "special_offer_room_type_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "special_offer_id")
    private SpecialOffer specialOffer;
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;
    @Column(name = "discount")
    private Double discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }

    public void setSpecialOffer(SpecialOffer specialOffer) {
        this.specialOffer = specialOffer;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
