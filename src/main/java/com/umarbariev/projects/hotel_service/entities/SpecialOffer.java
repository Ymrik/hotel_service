package com.umarbariev.projects.hotel_service.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "special_offers")
public class SpecialOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "special_offer_id")
    private int id;
    @Column(name = "special_offer_name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany
    @JoinTable(
            name = "special_offers_additional_services",
            joinColumns = {@JoinColumn(name = "special_offer_id")},
            inverseJoinColumns = {@JoinColumn(name = "additional_service_id")}
    )
    private List<AdditionalService> additionalServices;

    @ManyToMany
    @JoinTable(
            name = "special_offers_room_types",
            joinColumns = {@JoinColumn(name = "special_offer_id")},
            inverseJoinColumns = {@JoinColumn(name = "room_type_id")}
    )
    private List<RoomType> roomTypes;

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
