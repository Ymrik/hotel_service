package com.umarbariev.projects.hotel_service.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "additional_services")
public class AdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "additional_service_id")
    private int id;
    @Column(name = "additional_service_name")
    private String name;
    @Column(name = "base_price")
    private Double basePrice;
    @Column(name = "description")
    private String description;
    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(mappedBy = "additionalServices")
    private List<SpecialOffer> specialOffers;

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

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
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
