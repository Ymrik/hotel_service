package com.umarbariev.projects.hotel_service.repositories.special_offer;

import com.umarbariev.projects.hotel_service.entities.special_offer.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Integer> {
}
