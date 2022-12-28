package com.umarbariev.projects.hotel_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteriaDto {
    private Date arrivalDate;

    private Date departureDate;

    private int guestsCount;
}
