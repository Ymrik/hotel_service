package com.umarbariev.projects.hotel_service.entities.special_offer;

import com.umarbariev.projects.hotel_service.entities.additionalService.AdditionalService;

import javax.persistence.*;

@Entity
@Table(name = "special_offers_additional_services")
public class SpecialOfferAdditionalService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "special_offer_additional_service_id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "special_offer_id")
    private SpecialOffer specialOffer;
    @ManyToOne
    @JoinColumn(name = "additional_service_id")
    private AdditionalService additionalService;
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

    public AdditionalService getAdditionalService() {
        return additionalService;
    }

    public void setAdditionalService(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
